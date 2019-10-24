/**
 * @author Andrea Tongsak
 * value - takes a state as input and returns the int value of that number
 * toString - returns the string representation of the numeric value of the number
 */
public class Variable implements Expression {
  /**
   * Stores name of variable, private as required by class 
   */
  private String name;
  
  /**
   * The constructor for the class to replace default constructor.
   * @param name – the input string given by user
   */ 
  public Variable(String name) {
    this.name = name;
  }
  
  /*
   * This method takes a variable name and returns the int value
   * @param name – the name of variable
   * @return int – the int value associated with variable
   */ 
  public int value(State name) {
    return inputState.lookup(name);
  }
  
  /*
   * This method the string representation of the numeric vlaue
   * @return String – the returned string that represents the numeric value
   */ 
  public String toString() {
    return this.name;
  }
  
}


