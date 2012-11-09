package se.nctrl.jenkins.plugin;
import hudson.AbortException;
import hudson.Launcher;
import hudson.Extension;
import hudson.FilePath;
import hudson.FilePath.FileCallable;
import hudson.Util;
import hudson.util.FormValidation;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.AbstractProject;
import hudson.model.TaskListener;
import hudson.remoting.VirtualChannel;
import hudson.tasks.Builder;
import hudson.tasks.BuildStepDescriptor;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.QueryParameter;

import javax.servlet.ServletException;
import java.io.IOException;
import hudson.tasks.test.TabulatedResult;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;


@Extension
public class CTResultParser extends hudson.tasks.test.DefaultTestResultParserImpl {

    private AbstractBuild build;
    private static final String logname = "suite.log";
    
    private class FF implements IOFileFilter {

        
        public boolean accept(File file) {
            if (file.getName().equals(logname)) {
                return true;
            } else {
                return false;
                
            }

        }

        public boolean accept(File dir, String name) {
            if (name.equals(logname)) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    
    @Override
    protected TestResult parse(List<File> list, Launcher lnchr, TaskListener tl) throws InterruptedException, IOException {
        
        CTResult parsed_result = new CTResult(this.build);

        for (File f : list) {
            tl.getLogger().println("Reading log file  " + f.toString());
            CTLogParser p =  new CTLogParser(this.build);
            CTResult res = p.parse(f);
            parsed_result.addChild(res);
            
        }
        
        printSummary(parsed_result, tl);
        return parsed_result;
        
    }

    private String ctSummary(CTResult ctr)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(ctr.getDisplayName());
        sb.append(" : ");
        String res;
        
        switch (ctr.getResult()) {
            case -1: res = "ERROR"; break;
            case 0: res = "FAIL"; break;
            case 1: res = "PASS"; break;
            case 2: res = "SKIPPED"; break;
            default: res = "n/a"; break;
        }
        sb.append(res);

        return sb.toString();
    }
    
    private void printSummary(CTResult root, TaskListener tl)
    {
        tl.getLogger().println("# CT Test Result Summary"); 
        for (CTResult c: root.getChildren())
        {
            tl.getLogger().println("## " + ctSummary(c)); 
            for (CTResult cc: c.getChildren()) {
                tl.getLogger().println("*   " + ctSummary(cc)); 
               
            }
        }
    }
    
    public TestResult parse(final String testResultLocations, final boolean useGlob, final AbstractBuild build, final Launcher launcher, final TaskListener listener) throws InterruptedException, IOException {
        
            this.build = build;
    
    // part below is based on DefaultTestResultParserImpl
            return build.getWorkspace().act(new FileCallable<TestResult>() {
            final boolean ignoreTimestampCheck = IGNORE_TIMESTAMP_CHECK; // so that the property can be set on the master
            final long buildTime = build.getTimestamp().getTimeInMillis();
            final long nowMaster = System.currentTimeMillis();

            public TestResult invoke(File dir, VirtualChannel channel) throws IOException, InterruptedException {
                final long nowSlave = System.currentTimeMillis();

                // files older than this timestamp is considered stale
                long localBuildTime = buildTime + (nowSlave - nowMaster);
                FilePath[] paths;
                if (useGlob) {
                    paths = new FilePath(dir).list(testResultLocations);
                    if (paths.length == 0) {
                        throw new AbortException("No test reports that matches Glob " + testResultLocations + " found. Configuration error?");
                    }
                } else {
                    File root = new File(testResultLocations);
                    LinkedList<File> fl = (LinkedList<File>) FileUtils.listFiles(root ,new FF(), TrueFileFilter.INSTANCE);
                     if (fl.size() == 0) {
                        throw new AbortException("No test reports that matches absolute path " + testResultLocations + " found. Configuration error?");
                    }
                    paths = new FilePath[fl.size()];
                    int i = 0;
                    for (File f : fl) { // ugly! refactor.
                       paths[i] = new FilePath(f);
                       i = i + 1;
                    }
                }

                // since dir is local, paths all point to the local files
                List<File> files = new ArrayList<File>(paths.length);
                for (FilePath path : paths) {
                    File report = new File(path.getRemote());
                    if (ignoreTimestampCheck || localBuildTime - 3000 /*error margin*/ < report.lastModified()) {
                        // this file is created during this build
                        files.add(report);
                    }
                }

                if (files.isEmpty()) {
                    // none of the files were new
                    throw new AbortException(
                        String.format(
                        "Test reports were found but none of them are new. Did tests run? \n"+
                        "For example, %s is %s old\n", paths[0].getRemote(),
                        Util.getTimeSpanString(localBuildTime-paths[0].lastModified())));
                }

                return parse(files,launcher,listener);
            }
        });
    }
    
    @Override
    public TestResult parse(String testResultLocations, AbstractBuild build, Launcher launcher, TaskListener listener) throws InterruptedException, IOException {
        this.build = build;
        return super.parse(testResultLocations, build, launcher, listener);
    }

    
  

 
}

