
package se.nctrl.jenkins.plugin;

import hudson.model.AbstractBuild;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author a2l
 */
public class CTResult  extends TestResult{

    private AbstractBuild<?, ?> builder;
    private TestObject parent;
    private Collection<TestResult> children;
    
    private boolean hasChildren() {
        if (this.children != null) {
            return this.children.isEmpty();
        } else {
            return false;
        }
    }
  
    public void addChild(TestResult child)
    {
        if (this.children == null) {
            this.children = new ArrayList<TestResult>();
        }
        
        this.children.add(child);
        child.setParent(this);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getDisplayName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
