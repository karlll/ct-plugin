
package se.nctrl.jenkins.plugin;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author karl
 */
public class CTLogParserTest {
    
 private class LogFormatter extends SimpleFormatter
 {
     @Override
    	public String format(LogRecord record) {
         return this.formatMessage(record)  + "\r\n";
         
	} 
 }
 
 private class FF implements FileFilter
 {

        public boolean accept(File pathname) {
            System.out.println(pathname);
         return true;
            
        }
     
 }

  private class aFF implements IOFileFilter
 {

        public boolean accept(File file) {
            System.out.println(file);
         return true;
            
        }

        public boolean accept(File dir, String name) {
            System.out.println(dir + " : " + name);
            return true;
        }
     
 }

 
 public CTLogParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
  
    
    Logger ctlp_logger = Logger.getLogger(CTLogParser.class.getName());
    Handler ctlp_handler = new ConsoleHandler(); 
 
    ctlp_handler.setLevel(Level.ALL);
    ctlp_logger.addHandler(ctlp_handler);
    ctlp_logger.setLevel(Level.ALL);
    Formatter f = new LogFormatter();
    ctlp_handler.setFormatter(f);
   
    }
    
    @After
    public void tearDown() {
    }


    
    @Test
    public void testParse() {

        CTLogParser p = new CTLogParser(null);
        URL u = this.getClass().getResource("/suite2.log");
        String f = u.getFile();
        
        try {
            p.parse(new File(f));
        } catch (FileNotFoundException ex) {
           fail("Got FileNotFoundException");
        } catch (IOException ex) {
           fail("Got IOException");
        }
        
        
    
    }
}
