
package se.nctrl.jenkins.plugin;

import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.model.DirectoryBrowserSupport;
import hudson.tasks.junit.CaseResult;
import hudson.tasks.test.AbstractTestResultAction;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.ServletException;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

/**
 *
 * @author karl
 */
public class CTResultAction  extends AbstractTestResultAction<CTResultAction> {

    private CTResult result = null;
    private transient BuildListener bl;
    private static final String viewURL = "ctResults";
    
    public CTResultAction(AbstractBuild owner, CTResult result, BuildListener bl) {
        super(owner);
        this.result = result;
        this.bl = bl;
        
    }

    @Override
    public int getFailCount() {
        return this.result.getTotalFailedCases();
    }

    @Override
    public int getTotalCount() {
        return this.result.getTotalCases(); 
    }

    @Override
    public Object getResult() {
        return this.result;
    }
    
    @Override
    public int getSkipCount() {
        return this.result.getTotalSkippedCases();
    }

    @Override
    public String getDisplayName() {
        return "Common Test Results";
    }

    @Override
    public String getUrlName() {
        return viewURL;
    }

    public static String resultToText(int res)
    {
        switch (res)
        {
            case 0: return "Failed";
            case 1: return "Passed";
            case 2: return "Skipped";
            default: return "Error";
        }
    }
    
   
    
}
