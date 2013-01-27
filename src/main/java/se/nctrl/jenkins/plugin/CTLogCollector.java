package se.nctrl.jenkins.plugin;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.model.Result;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import hudson.util.FormValidation;
import java.io.IOException;
import javax.servlet.ServletException;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;




public class CTLogCollector extends Recorder {


    private final String log_path;
    
    @DataBoundConstructor
    public CTLogCollector(String path) {
        this.log_path = path;
    }

    public String getPath() {
        return this.log_path;
    }

    @Override
    public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
        
           
           
           CTResultParser log_p = new CTResultParser();
           CTResult res = (CTResult) log_p.parse(log_path, build, launcher, listener);
            
            if (!res.isPassed())
            {
                build.setResult(Result.UNSTABLE);
            }
            
            CTResultAction res_action = new CTResultAction(build,res,listener);
            build.addAction(res_action);
            
            return true;
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl)super.getDescriptor();
    }

    
    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.STEP;
        
    }

  
    @Override
    public Action getProjectAction(AbstractProject<?, ?> project) {
                return null;
    }
    
   
    
    @Extension 
    public static final class DescriptorImpl extends BuildStepDescriptor<Publisher> {
        
        
        public String getDisplayName() {
            return "Collect Common Test results";
            
        }
        
        public FormValidation doCheckPath(@QueryParameter String value)
                throws IOException, ServletException {
            if (value.length() == 0)
            { 
                return FormValidation.error("Please provide a log root path");
            }
            return FormValidation.ok();
        }

        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            return true;
        }



        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
            save();
            return super.configure(req,formData);
        }

       
    }
}

