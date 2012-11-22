
package se.nctrl.jenkins.plugin;


import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.tasks.test.AbstractTestResultAction;

/**
 *
 * @author karl
 */
public class CTResultAction  extends AbstractTestResultAction<CTResultAction> {

    private CTResult result = null;
    private transient BuildListener bl;
    private static final String viewURL = "ctResults";
    private transient CTReportLayout report_layout = null;

    public CTResultAction(AbstractBuild owner, CTResult result, BuildListener bl) {
        super(owner);
        this.result = result;
        this.bl = bl;
        this.report_layout = new CTReportLayout(this.result);
        
        
    }

    
    public CTReportLayout getReport_layout() {
        return report_layout;
    }
    
    @Override
    public int getFailCount() {
        return this.result.getTotalFailedCases();
    }

    public int getPassCount() {
        return this.result.getTotalPassedCases();
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
