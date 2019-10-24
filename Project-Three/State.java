import java.util.*;

/**
 * A class that stores and retrieves variables.
 * @author <em>Andrea Tongsak</em>
 */
public class State {
  /** 
   * HashTable that stores all variables for the language 
   */
  private static Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
  
  /**
   * Adds a new variable to the HashTable
   * @param varName name of new variable
   * @param varValue value of the new variable
   */ 
  public void update(String varName, int varValue) {
    hash.put(varName, varValue);
  }
  
  /**
   * Looks up values for variable in the language
   * @param varName name of variable to look up
   * @return int from HashTable
   */ 
  public int lookup(String varName) {
    try {
      return hash.get(varName);
    } catch (Exception e) {
      return 0;
    }
  }
  
}