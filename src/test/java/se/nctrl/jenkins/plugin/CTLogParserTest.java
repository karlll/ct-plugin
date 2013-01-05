
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
    
    private final static String TEST_SUITE_LOG = "/logs/asn1_test_logs/ct_run.ct@devbox.2012-11-19_16.37.18/tests.asn1_test.logs/run.2012-11-19_16.37.20/suite.log";
    private final static String TEST_SUREFIRE_LOG = "/logs/asn1_test_logs/ct_run.ct@devbox.2012-11-19_16.37.18/junit_report.xml";
    
    private class LogFormatter extends SimpleFormatter
 {
     @Override
    	public String format(LogRecord record) {
         return this.formatMessage(record)  + "\r\n";
         
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
  
    
    Logger ctlp_logger = Logger.getLogger(CTSuiteLogParser.class.getName());
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
    public void testParseSuiteLog() {

        CTLogParser p = new CTSuiteLogParser(null);
        URL u = this.getClass().getResource(TEST_SUITE_LOG);
        String f = u.getFile();
        CTResult res = null;
        try {
             res = p.parse(new File(f));
        
            assertNotNull(res);
        
             
        } catch (FileNotFoundException ex) {
           fail("Got FileNotFoundException");
        } catch (IOException ex) {
           fail("Got IOException");
        } catch (Exception ex) { fail ("Got exception when parsing"); }
       
        CTResult t = CTResultTestUtil.getMockResultObject();      
        CTResultTestUtil.DiffResult d_res = CTResultTestUtil.diff(res, t);
        
        if (!d_res.eq) {
        
            System.out.print("Diff :\n");
            System.out.print(d_res.diff_list);
            fail("Parsed CTResult does not match test data.");
        }
        

    }

    @Test
    public void testParseSurefireLog() {

        CTLogParser p = new CTSurefireLogParser(null);
        URL u = this.getClass().getResource(TEST_SUREFIRE_LOG);
        String f = u.getFile();
        
        
        

        
        try {
            CTResult res = p.parse(new File(f));
            
            assertNotNull(res);
        } catch (FileNotFoundException ex) {
           fail("Got FileNotFoundException");
        } catch (IOException ex) {
           fail("Got IOException");
        } catch (Exception ex) { fail ("Got exception"); }

        
    
    }
    
}

