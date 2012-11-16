
package se.nctrl.jenkins.plugin;

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
public class CTResultTest {
    
    
    public CTResultTest() {
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

    /**
     * Test of addChild method, of class CTResult.
     */
    @Test
    public void testAddChild() {
        
        CTResult parent = new CTResult(null);
        CTResult child = new CTResult(null);

       
        parent.addChild(child);
        assertEquals(parent, child.getParent());
    
    }

    /**
     * Test of findCorrespondingResult method, of class CTResult.
     */
    @Test
    public void testFindCorrespondingResult() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisplayName method, of class CTResult.
     */
    @Test
    public void testGetDisplayName() {
        fail("The test case is a prototype.");
    }
}
