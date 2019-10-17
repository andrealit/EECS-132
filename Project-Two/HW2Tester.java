// Andrea Tongsak
// Tester class for HW 2

import org.junit.*;
import static org.junit.Assert.*;

public class HW2Tester {
  
  /**
   * Test the isAlphabeticalOrder method.
   * (1) "isAlphabeticalOrder" takes a String as input and returns a boolean: The method returns true if all the letters 
   * of the input string are in alphabetical order, regardless of case. The method returns false otherwise.
   */
  @Test
  public void testIsAlphabeticalOrder() {
    
    // Should return "true" for this
    // String str = "ac!ffG1hz";
    
    // Should return "false" for this
    // String str = "ac!nfG1h";
    
    
    // Test 0, test 1, test many
    
    // Test 0 (no letters)
    assertTrue("Incorrectly claims \"11\" is not in alphabetical order", HW2.isAlphabeticalOrder("11"));
    // Test 1 (one letter)
    assertTrue("Incorrectly claims \"a\" is not in alphabetical order", HW2.isAlphabeticalOrder("a"));
    // Test many (many letters)
    assertTrue("Incorrectly claims \"abcd\" is not in alphabetical order", HW2.isAlphabeticalOrder("abcd"));
    
    
    // Test first, test middle, test last
    
    
    // assert statements
    
    assertTrue("Incorrectly claims \"ac!ffG1hz\" is not in alphabetical order", HW2.isAlphabeticalOrder("ac!ffG1hz"));
    assertFalse("Incorrectly claims \"ac!nfG1h\" is in alphabetical order", HW2.isAlphabeticalOrder("ac!nfG1h"));
    
    
    
    
  }
  
  
  /**
   * Test the removeNchars method.
   * (2) "removeNchars" takes a String, an int and a char and returns a String: The output string is the same as the 
   * input string except that the first n occurrences of the input char are removed from the string, where n represents 
   * the input integer. If there are not n occurrences of the input character, then all occurrences of the character are 
   * removed.
   */
  @Test
  public void testRemoveNchars() {
    
    String str = "Hello there!";
    String str1 = "Hllo thre!";
    String str2 = "Hllo thr!";
    String str3 = "Hello tere!";
    
    // Should return "Hllo thre!" for this
    // HW2.removeNchars("Hello there!", 2, 'e')
    
    // Should return "Hllo thr!" for this
    // HW2.removeNchars("Hello there!", 10, 'e')
    
    // Should return "Hello tere!" for this
    // HW2.removeNchars("Hello there!", 1, 'h')
    
    assertEquals(str1, HW2.removeNchars(str, 2, 'e'));
    assertEquals(str2, HW2.removeNchars(str, 10, 'e'));
    assertEquals(str3, HW2.removeNchars(str, 1, 'h'));
                 
                 
    // Test 0, test 1, test many
    
    // Test first, test middle, test last
    
  }
  
  
  /**
   * Test the removeString method.
   * (3) "removeString" takes two Strings and returns a String: The output string should be the same as the first input 
   * string except that every occurrence of the second input string should be removed. 
   * If a string exists twice as an overlap (ex: "ellelle" contains two "elle"), the first occurrence is removed. 
   * You do not remove strings that are created by the removal of other strings.
   */
  @Test
  public void testRemoveString() {
    // Should return "elle"
    // HW2.removeString("ellelle", "elle")
    
    // Should return "elle"
    // HW2.removeString("elellele", "elle")
    
    // Should return "ll"
    // HW2.removeString("ellellelle", "elle")
    
    String str = "elle";
    String str1 = "ell";
    String str2 = "elle";
    String str3 = "holl";
    String emptyStr = "";
    
    // should not remove 'elle'
    assertEquals(str1, HW2.removeString(str1, str));
    
    // should return empty string
    assertEquals(emptyStr, HW2.removeString(str2, str));
    
    // should return 'holl'
    assertEquals(str3, HW2.removeString(str3, str));
    
    
    assertEquals("lle", HW2.removeString("ellelle", "elle"));
    assertEquals("elle", HW2.removeString("elellele", "elle"));
    assertEquals("ll", HW2.removeString("ellellelle", "elle"));
    
  }
//  
//  /**
//   * Test the moveAllXsRight method.
//   * (4) "moveAllXsRight" takes a char and a String as input and returns a String: The output string should be the same 
//   * as the input string except that every occurrence of the input character should be shifted one character to the right. 
//   * If it is impossible to shift a character to the right (it is at the end of the string), then it is not shifted. 
//   */
//  @Test
//  public void testMoveAllXsRight() {
//    // Should return "abcdXefXXXghiXjXXXX"
//    // HW2.moveAllXsRight('X', "abcXdeXXXfghXiXXjXX") 
//    
//    assertEquals("abcXdeXXXfghXiXXjXX", HW2.moveAllXsRight('X', "abcXdeXXXfghXiXXjXX"), "Does not move 'X' correctly");
//    
//  }
//  
//  /**
//   * Test the moveAllXsDown method.
//   * (5) "moveAllXsDown" takes a char and a two dimensional array of char as input and returns nothing: The method 
//   * should take every occurrence of the input character and shift it "down" to the next row of the array, and at the 
//   * same column. If it is impossible to to shift the character down (it is at the "bottom" row or the row below 
//   * does not have that column), then it is not shifted.
//   */
//  @Test
//  public void testMoveAllXsDown() {
//    // Should return 
//    
//  }
  
  
}