package se.nctrl.jenkins.plugin;

import hudson.Extension;
import hudson.FilePath;
import hudson.FilePath.FileCallable;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.TaskListener;
import hudson.remoting.VirtualChannel;
import hudson.tasks.test.TestResult;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Extension
public class CTResultParser extends hudson.tasks.test.DefaultTestResultParserImpl {

    private static final String logname = "suite.log";
    private String expandedTestResultLocation;
  
    @Override
    protected TestResult parse(List<File> list, Launcher lnchr, TaskListener tl) throws InterruptedException, IOException {
        
        CTResult parsed_result = new CTResult();

        for (File f : list) {
            tl.getLogger().println("Reading log file  " + f.toString());
            CTSuiteLogParser p =  new CTSuiteLogParser();
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
    
  
public TestResult parse(final String testResultLocations, final AbstractBuild build, final Launcher launcher, final TaskListener listener) throws InterruptedException, IOException {
        
            
            this.expandedTestResultLocation = build.getEnvironment(listener).expand(testResultLocations);
            
            TestResult root = build.getWorkspace().act(new FileCallable<TestResult>()
            {
                
                
                public TestResult invoke(File file, VirtualChannel vc) throws IOException, InterruptedException {
         
                    
                    CTResult parsed_result = new CTResult();
                    CTSuiteLogParser p =  new CTSuiteLogParser();
                    FilePath root = new FilePath(new File(expandedTestResultLocation));   
                    FilePath[] fs = root.list("**/" + logname);
                    
                    
                    for (FilePath path : fs) {
                        listener.getLogger().println("Parsing log file : " + path.getRemote());
                        CTResult res = p.parse(new File(path.getRemote()));
                        parsed_result.addChild(res);
                        
                    }
                    
                                       
                    printSummary(parsed_result, listener);
                    
                    return parsed_result;
                    
                    
                }
            });
            
            return root;
    }

    
   

 
}

