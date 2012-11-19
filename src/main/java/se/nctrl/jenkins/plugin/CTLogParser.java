
package se.nctrl.jenkins.plugin;

import hudson.model.AbstractBuild;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author karl
 */
public abstract class CTLogParser {
    
    private AbstractBuild build;
    
    public CTLogParser(AbstractBuild build)
    {
        this.build = build;
    }
    
    public AbstractBuild getBuild()
    {
        return this.build;
    }
            
    
    public abstract CTResult parse(File f) throws FileNotFoundException, IOException;
    
            
}
