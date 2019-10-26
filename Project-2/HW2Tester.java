// Andrea Tongsak
// Tester class for HW 2

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class HW2Tester {
  
  /**
   * Test the isAlphabeticalOrder method.
   * (1) "isAlphabeticalOrder" takes a String as input and returns a boolean: The method returns true if all the letters 
   * of the input string are in alphabetical order, regardless of case. The method returns false otherwise.
   */
  @Test
  public void testIsAlphabeticalOrder() {
    
    /* Test 0, test 1, test many */
    
    // Length
    // Test 0 (length 0)
    assertTrue("Incorrectly claims \"\" is not in alphabetical order", HW2.isAlphabeticalOrder(""));
    // Test 1 (length 1)
    assertTrue("Incorrectly claims \"a\" is not in alphabetical order", HW2.isAlphabeticalOrder("a"));
    // Test many (length many)
    assertTrue("Incorrectly claims \"abcd\" is not in alphabetical order", HW2.isAlphabeticalOrder("abcd"));
    
    // Letters
    // Test 0 (no letters)
    assertTrue("Incorrectly claims \"11\" is not in alphabetical order", HW2.isAlphabeticalOrder("11"));
    // Test 1 (1 letters)
    assertTrue("Incorrectly claims \"11\" is not in alphabetical order", HW2.isAlphabeticalOrder("a2"));
    // Test many (many letters)
    assertTrue("Incorrectly claims \"11\" is not in alphabetical order", HW2.isAlphabeticalOrder("a2bdeh"));
    
    
    /* Test first, test middle, test last */
    
    // Test first (occurance of no order in beginning of string)
    assertFalse("Incorrectly claims \"zac!ffG1hz\" is in alphabetical order", HW2.isAlphabeticalOrder("zac!ffG1hz"));
    
    // Test middle (occurance of no order in middle)
    assertFalse("Incorrectly claims \"ac!ZfG1hz\" is in alphabetical order", HW2.isAlphabeticalOrder("ac!ZfG1hz"));
    
    // Test last (occurance of no order at end)
    assertFalse("Incorrectly claims \"ac!ffG1hzA\" is in alphabetical order", HW2.isAlphabeticalOrder("ac!ffG1hzA"));
    
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
    String expectedStr1 = "Hllo thre!";
    String expectedStr2 = "Hllo thr!";
    String expectedStr3 = "Hello tere!";
    String expectedStr4 = "ello there!";
    String expectedStr5 = "Heo there!";
    String expectedStr6 = "Hello there";
                 
    /* Test 0, test 1, test many */
    
    // Length
    // Test 0 (length 0)
    assertEquals("", HW2.removeNchars("", 2, 'j'));
    // Test 1 (length 1)
    assertEquals("", HW2.removeNchars("j", 1, 'j'));
    // Test Many (length many!)
    assertEquals(expectedStr2, HW2.removeNchars(str, 10, 'e'));
    
    // Integers
    // Test 0 (remove 0)
    assertEquals(str, HW2.removeNchars(str, 0, 'j'));
    // Test 1 (remove 1)
    assertEquals(expectedStr4, HW2.removeNchars(str, 1, 'H'));
    // Test Many (remove many!)
    assertEquals(expectedStr2, HW2.removeNchars(str, 10, 'e'));
    
    // Letters
    // Test 0 (no char)
    assertEquals("00", HW2.removeNchars("00", 1, 'j'));
    // Test 1 (1 char)
    assertEquals("a", HW2.removeNchars("ab", 1, 'b'));
    // Test many (many char)
    assertEquals("a", HW2.removeNchars("abbbb", 4, 'b'));
    
    
    /* Test first, test middle, test last */
    
    // Test first (first char remove)
    assertEquals(expectedStr4, HW2.removeNchars(str, 1, 'H'));
    // Test middle (middle char remove)
    assertEquals(expectedStr5, HW2.removeNchars(str, 3, 'l'));
    // Test last (last char remove)
    assertEquals(expectedStr6, HW2.removeNchars(str, 3, '!'));
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
    
    /* Test 0, test 1, test many */
    
    // Length
    // Test 0 (length 0)
    assertEquals("", HW2.removeString("", "elle"));
    assertEquals("elle", HW2.removeString("elle", ""));
    // Test 1 (length 1)
    assertEquals("e", HW2.removeString("e", "elle"));
    assertEquals("ll", HW2.removeString("elle", "e"));
    // Test Many (length many!)
    assertEquals("e", HW2.removeString("elleeelle", "elle"));
    
    // Word
    // Test 0 (no word)
    assertEquals("ellg", HW2.removeString("ellg", "elle"));
    assertEquals("elelgele", HW2.removeString("elelgele", "elle"));
    // Test 1 (one instance of word)
    assertEquals("", HW2.removeString("elle", "elle"));
    // Test many (two instances of word)
    assertEquals("ll", HW2.removeString("ellellelle", "elle"));
    
    
    /* Test first, test middle, test last */
    
    // Test first
    assertEquals("lle", HW2.removeString("ellelle", "elle"));
    // Test middle
    assertEquals("elle", HW2.removeString("elellele", "elle"));
    // Test last
    assertEquals("elel", HW2.removeString("elelelle", "elle"));
    
    
  }
  
  /**
   * Test the moveAllXsRight method.
   * (4) "moveAllXsRight" takes a char and a String as input and returns a String: The output string should be the same 
   * as the input string except that every occurrence of the input character should be shifted one character to the right. 
   * If it is impossible to shift a character to the right (it is at the end of the string), then it is not shifted. 
   */
  @Test
  public void testMoveAllXsRight() {
    
    /* Test 0, test 1, test many */
    
    // Length
    // Test 0 (length 0)
    assertEquals("", HW2.moveAllXsRight('X', ""));
    // Test 1 (length 1)
    assertEquals("X", HW2.moveAllXsRight('X', "X"));
    // Test many (length many)
    assertEquals("jXuju", HW2.moveAllXsRight('X', "Xjuju"));

    // Char
    // Test 0 (no char move)
    assertEquals("ab", HW2.moveAllXsRight('X', "ab"));
    // Test 1 (one char move right)
    assertEquals("abXcd", HW2.moveAllXsRight('X', "aXbcd"));
    assertEquals("abXcdefXg", HW2.moveAllXsRight('X', "aXbcdeXfg"));
    // Test many (multiple chars move)
    assertEquals("abcdXefXXXghiXjXXXX", HW2.moveAllXsRight('X', "abcXdeXXXfghXiXXjXX"));
    
    
    /* Test first, test middle, test last */
    // Test first (first index)
    assertEquals("aXb", HW2.moveAllXsRight('X', "Xab"));
    // Test middle (middle of String)
    assertEquals("abcdeXXfg", HW2.moveAllXsRight('X', "abcdXXefg"));
    // Test last (end of String)
    assertEquals("aX", HW2.moveAllXsRight('X', "aX"));
    
  }
  

}
