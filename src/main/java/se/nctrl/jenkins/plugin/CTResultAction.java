
package se.nctrl.jenkins.plugin;

import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.model.DirectoryBrowserSupport;
import hudson.tasks.test.AbstractTestResultAction;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.servlet.ServletException;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

/**
 *
 * @author karl
 */
public class CTResultAction extends AbstractTestResultAction<CTResultAction> {

    private CTResult result;
    private BuildListener bl;
    
    public CTResultAction(AbstractBuild owner, CTResult result, BuildListener bl) {
        super(owner);
        this.result = result;
        this.bl = bl;
    }

    @Override
    public int getFailCount() {
        return this.result.getFailed();
    }

    @Override
    public int getTotalCount() {
        return this.result.getCases(); // TODO : fix this
    }

    @Override
    public Object getResult() {
        return this.result;
    }
    
    @Override
    public int getSkipCount() {
        return this.result.getSkipCount();
    }

    @Override
    public String getDisplayName() {
        return "Common Test Results";
    }

    @Override
    public String getUrlName() {
        return "viewCtResults";
    }
/*
    public DirectoryBrowserSupport doDynamic(StaplerRequest req, StaplerResponse rsp)
            throws IOException, ServletException, InterruptedException {

        AbstractBuild<?, ?> build = result.getOwner();
        AbstractProject<?, ?> project = build.getProject();
        FilePath systemDirectory = new FilePath(new File(build.getRootDir(),"ctreport2"));
        return new DirectoryBrowserSupport(this, systemDirectory, "Test Report", null, false);
    }
    * */
    public void doViewCtResults(StaplerRequest req, StaplerResponse rsp)throws IOException, ServletException, InterruptedException
    {
       //rsp.serveFile(req, new URL("http://www.google.com")); 
       rsp.sendRedirect2("http://www.google.com");
    }
}
