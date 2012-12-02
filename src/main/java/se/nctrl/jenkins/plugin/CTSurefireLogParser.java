package se.nctrl.jenkins.plugin;

import hudson.model.AbstractBuild;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author karl
 */
public class CTSurefireLogParser extends CTLogParser {

    public CTSurefireLogParser(AbstractBuild build)
    {
        super(build);
    }
    
    @Override
    public CTResult parse(File f) throws FileNotFoundException, IOException {
        
        
        return null;
        
    }
    
}
