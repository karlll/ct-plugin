
package se.nctrl.jenkins.plugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author karl l <karl@ninjacontrol.com>
 */
public abstract class CTLogParser {
    
    public abstract CTResult parse(File f) throws FileNotFoundException, IOException;
    
            
}
