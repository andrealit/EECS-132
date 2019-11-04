/**
 * @author Andrea Tongsak
 * value takes a state as input and returns the int value of that number
 * getName returns the name of variable
 * toString returns the string representation of the numeric value of the number
 */
public class Variable implements ExpressionInt {
  /**
   * Stores name of variable, protected so accessible by subclasses
   */
  protected String name;
  
  /**
   * The constructor for the class to replace default constructor.
   * @param name the input string given by user
   */ 
  public Variable(String name) {
    this.name = name;
  }
  
  /*
   * This method takes a variable name and returns the int value
   * @param state where variable stored 
   * @return int the int value associated with variable
   */ 
  public int value(State state) {
    return state.lookup(name);
  }
  
  /*
   * This method returns the name of the variable
   * @return String 
   */ 
  public String getName() {
    return this.name;
  }
  
  /*
   * This method returns the string representation of the numeric value
   * @return String the returned string that represents the numeric value
   */ 
  public String toString() {
    return this.name;
  } 
  
  
  
}


