package apache2tray;

import org.junit.*;
import static org.junit.Assert.*;

public class ConsoleHandlerTest {
    
    private ConsoleHandler consolehandler = new ConsoleHandler();
    
    public ConsoleHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testApacheIsRunningReturnsTrueWhenNotPassingIntNull() {
        assertTrue(this.consolehandler.apacheIsRunning(1));
        assertTrue(this.consolehandler.apacheIsRunning(4));
        assertTrue(this.consolehandler.apacheIsRunning(2));
        assertTrue(this.consolehandler.apacheIsRunning(15));
    }
    
    @Test
    public void testApacheIsRunningReturnsFalseWhenPassingIntNull() {
        assertFalse(this.consolehandler.apacheIsRunning(0));
    }
    
    @Test
    public void testGetApacheStatusReturnsFalseWhenNotRunning() {
        assertFalse(this.consolehandler.getApacheStatus());
    }
    
}
