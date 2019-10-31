/**
 * A tester class for HW3
 * @author Andrea Tongsak
 * 
 */
import org.junit.*;
import static org.junit.Assert.*;

/* 
 * A testing class for HW2 Methods 1-4
 * A conditional statement will need tests that go through each branch of the execution. 
 * Any loops will need tests that cover "test 0, test 1, test many" and "test first, test middle, test last"
 */ 
public class HW3Tester {
  /**
   * Test the update and lookup method in State class.
   */
  @Test
  public void testState() {
    
    State stateTest = new State();

    stateTest.update("x", 10);
    assertEquals(10, stateTest.lookup("x"));

  }
  
  /*
   * Test the 
   */ 
  
  
  
  
}