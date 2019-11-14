import org.junit.*;
import static org.junit.Assert.*;

/**
 * A tester class for HW4
 * @author Andrea Tongsak
 * 
 */
public class HW4Tester {
  /**
   * Additional Requirement
   * 
   * railyard and train where cycle sort is allowed, closest sort fails
   * railyard and train where cycle sort fails, closest sort allowed
   */ 
  @Test 
  public void additionalRequirement() {
    // railyard and train where cycle sort fails, closest sort is allowed
    int[] arr = {3, 3};
    RailYard<Integer> s = new RailYard<Integer>(arr);
    Integer[] trainUnsorted = {11, 23, 1, 7, 13, 3, 29, 19, 17};
    Integer[] trainSorted = {1, 3, 7, 11, 13, 17, 19, 23, 29};
    s.cycleSort(trainUnsorted);
    
    assertNotSame(trainSorted, trainUnsorted);
    
    int[] arr1 = {3, 3};
    RailYard<Integer> s1 = new RailYard<Integer>(arr1);
    Integer[] trainUnsorted1 = {11, 23, 1, 7, 13, 3, 29, 19, 17};
    Integer[] trainSorted1 = {1, 3, 7, 11, 13, 17, 19, 23, 29};
    s1.closestSort(trainUnsorted1);
    
    assertArrayEquals(trainSorted1, trainUnsorted1);
    
    // still need test where cycle sort is able, and closest sort fails

  
  }
  
  /**
   * Tests the "Cycle Sort" algorithm
   */ 
  @Test
  public void cycleSort() {
    // TEST INTEGER
    // Test 0 for constructor array
    int[] arr = new int[0];
    RailYard<Integer> s = new RailYard<Integer>(arr);
    Integer[] trainUnsorted = {3, 1, 4, 5, 1, 9, 6};
    Integer[] trainSorted = {3, 1, 4, 5, 1, 9, 6};
    s.cycleSort(trainUnsorted);
    
    assertArrayEquals(trainSorted, trainUnsorted);
    
    // Test 1 for constructor array
    int[] arr1 = {1};
    RailYard<Integer> s1 = new RailYard<Integer>(arr1);
    Integer[] trainUnsorted1 = {3, 1, 4, 5, 1, 9, 6};
    Integer[] trainSorted1 = {1, 1, 3, 4, 5, 6, 9};
    s.cycleSort(trainUnsorted1);
    
    assertArrayEquals(trainSorted1, trainUnsorted1);
    
    // Test many for constructor array
    int[] arr2 = {2, 3};
    RailYard<Integer> s2 = new RailYard<Integer>(arr2);
    Integer[] trainUnsorted2 = {3, 1, 4, 5, 1, 9, 6};
    Integer[] trainSorted2 = {1, 1, 3, 4, 5, 6, 9};
    s.cycleSort(trainUnsorted2);
    
    assertArrayEquals(trainSorted2, trainUnsorted2);
    
    // First, middle, last
    // Test first (first section scrambled)
    int[] arr3 = {2, 3};
    RailYard<Integer> s3 = new RailYard<Integer>(arr3);
    Integer[] trainUnsorted3 = {3, 1, 4, 5, 1, 9, 6, 7, 7, 7, 7};
    Integer[] trainSorted3 = {1, 1, 3, 4, 5, 6, 7, 7, 7, 7, 9};
    s3.cycleSort(trainUnsorted3);
    
    assertArrayEquals(trainSorted3, trainUnsorted3);
    
    // Test middle (middle section scrambled)
    
    
    // can use try catch to check exceptios
    try {
      // code that should throw exception
      fail("");
    } catch (ArithmeticException e) {
      // everything is working!
    } catch (Exception e2) {
      fail("Threw the exception :<");
    }
    
  }
  
  /**
   * Tests the merge method
   */ 
  @Test
  
}