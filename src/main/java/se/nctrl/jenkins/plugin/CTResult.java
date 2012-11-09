
package se.nctrl.jenkins.plugin;

import hudson.model.AbstractBuild;
import hudson.model.Result;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author a2l
 */
public class CTResult  extends TestResult{

    private AbstractBuild<?, ?> builder;
    private TestObject parent;
    private Collection<CTResult> children;
    
  
    private int cases;
    private String user;
    private String host;
    private String hosts;
    private String lan;
    private String emulator_vsn;
    private String emulator;
    private String otp_release;
    private Date started;
    private String case_name;
    private String log_file;
    private Date ended;
    private int result;
    private String result_msg;
    private float elapsed;
    private String group_time;
    private Date finished;
    private int failed;
    private int successful;
    private int user_skipped;
    private int auto_skipped;
    private String group_props;
   
    
    public AbstractBuild<?, ?> getBuilder() {
        return builder;
    }

    public void setBuilder(AbstractBuild<?, ?> builder) {
        this.builder = builder;
    }

    public Collection<CTResult> getChildren() {
        return children;
    }

    public void setChildren(Collection<CTResult> children) {
        this.children = children;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHosts() {
        return hosts;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getEmulator_vsn() {
        return emulator_vsn;
    }

    public void setEmulator_vsn(String emulator_vsn) {
        this.emulator_vsn = emulator_vsn;
    }

    public String getEmulator() {
        return emulator;
    }

    public void setEmulator(String emulator) {
        this.emulator = emulator;
    }

    public String getOtp_release() {
        return otp_release;
    }

    public void setOtp_release(String otp_release) {
        this.otp_release = otp_release;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public String getCase_name() {
        return case_name;
    }

    public void setCase_name(String case_name) {
        this.case_name = case_name;
    }

    public String getLog_file() {
        return log_file;
    }

    public void setLog_file(String log_file) {
        this.log_file = log_file;
    }

    public Date getEnded() {
        return ended;
    }

    public void setEnded(Date ended) {
        this.ended = ended;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResult_msg() {
        return result_msg;
    }

    public void setResult_msg(String result_msg) {
        this.result_msg = result_msg;
    }

    public float getElapsed() {
        return elapsed;
    }

    public void setElapsed(float elapsed) {
        this.elapsed = elapsed;
    }

    public String getGroup_time() {
        return group_time;
    }

    public void setGroup_time(String group_time) {
        this.group_time = group_time;
    }

    public Date getFinished() {
        return finished;
    }

    public void setFinished(Date finished) {
        this.finished = finished;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public int getSuccessful() {
        return successful;
    }

    public void setSuccessful(int successful) {
        this.successful = successful;
    }

    public int getUser_skipped() {
        return user_skipped;
    }

    public void setUser_skipped(int user_skipped) {
        this.user_skipped = user_skipped;
    }

    public int getAuto_skipped() {
        return auto_skipped;
    }

    public void setAuto_skipped(int auto_skipped) {
        this.auto_skipped = auto_skipped;
    }

    public String getGroup_props() {
        return group_props;
    }

    public void setGroup_props(String group_props) {
        this.group_props = group_props;
    }

   
    
    private boolean hasChildren() {
        if (this.children != null) {
            return this.children.isEmpty();
        } else {
            return false;
        }
    }
  
    public void addChild(CTResult child)
    {
        if (this.children == null) {
            this.children = new ArrayList<CTResult>();
        }
        
        this.children.add(child);
        child.setParent(this);
    }
    
    public CTResult() {
        
        this.builder = null; // TODO : set this?
        this.children = null;
        
    }

     public CTResult(AbstractBuild<?, ?> builder) {
        
        this.builder = builder;
        this.children = null;
        
    }  
    
    @Override
    public AbstractBuild<?, ?> getOwner() {
        
        return this.builder;
        
    }

    @Override
    public TestObject getParent() {
        return this.parent;
    }

    @Override
    public  void setParent(TestObject parent) {
        this.parent = parent;
    }

    
    @Override
    public TestResult findCorrespondingResult(String string) {
        return null;
    }

    public String getDisplayName() {
        if (case_name != null) { return case_name; } else {
            if (this.hasChildren()) {
                String displayName = "CT Suite";
                if (this.started != null) {
                    displayName += " @ " + this.started.toString();
                }
                return "CT Suite";
            } else {
                return "Unknown";
            }
        } 
    
    }
    
private Collection<? extends TestResult> filterChildrenByResult( int result)
{
    ArrayList fa = new ArrayList<CTResult>();
    if (hasChildren())
    {
       
        for(CTResult r : this.children) {
            if (r.getResult() == result) { fa.add(r);}
        }
        
    }
    return fa;
}
    

//     @Override
//    public String annotate(String text) {
//        return "";
//    }

    @Override
    public Result getBuildResult() {
        switch (this.result) {
            case 0:
                return Result.UNSTABLE;
            case 1:
                return Result.SUCCESS;
            case 2:
                return Result.NOT_BUILT;
            default:
                return Result.FAILURE;
        }
    }

    @Override
    public float getDuration() {
        return this.elapsed;

    }

    @Override
    public String getErrorDetails() {
        if (this.result == 0) {
            return this.result_msg;
        } else {
            return "";
        }
    }

    @Override
    public String getErrorStackTrace() {
        return "";
    }

    @Override
    public int getFailCount() {
        return this.failed;
    }

    @Override
    public int getFailedSince() {
        return 0;
    }

    //@Override
    //public  Run<?,?>	getFailedSinceRun()  {return null;}
    
    @Override
    public Collection<? extends TestResult> getFailedTests() {
        return filterChildrenByResult(0);
    }

    //@Override
    //public AbstractTestResultAction	getParentAction()  {}

    @Override
    public int getPassCount() {
        return this.successful;
    }

    @Override
    public Collection<? extends TestResult> getPassedTests() {
        return filterChildrenByResult(1);

    }

    @Override
    public TestResult getPreviousResult() {
        return null;
    }

    @Override
    public int getSkipCount() {
        return this.auto_skipped + this.user_skipped;
    }

    @Override
    public Collection<? extends TestResult> getSkippedTests() {
        return filterChildrenByResult(2);
    }

    @Override
    public String getStderr() {
        return "stderr";
    }

    @Override
    public String getStdout() {
        return "stdout";
    }

    @Override
    public String getTitle() {
        return "title";
    }

    @Override
    public boolean isPassed() {
        return this.result == 1;
    }
 
    //@Override
    //public void	setParentAction(AbstractTestResultAction action)  {}

    //@Override
    //public void	tally()  {}

    
}
