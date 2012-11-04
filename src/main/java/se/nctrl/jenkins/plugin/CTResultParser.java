package se.nctrl.jenkins.plugin;
import hudson.Launcher;
import hudson.Extension;
import hudson.util.FormValidation;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.AbstractProject;
import hudson.model.TaskListener;
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
import java.util.Collection;
import java.util.List;


@Extension
public class CTResultParser extends hudson.tasks.test.DefaultTestResultParserImpl {

    @Override
    protected TestResult parse(List<File> list, Launcher lnchr, TaskListener tl) throws InterruptedException, IOException {
        
        //return new 
        return null;
    }

  

 
}

