/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nctrl.jenkins.plugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karl
 */
public class CTLogParserTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testParse() {

        CTLogParser p = new CTLogParser();
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
