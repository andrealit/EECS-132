/**
 * A representation of variables
 * @author <em>Andrea Tongsak</em>
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
   * This method takes a state and returns the int value
   * @param state where variable stored 
   * @return int the int value associated with variable
   */ 
  public int value(State state) {
    return state.lookup(name);
  }
  
  /*
   * This method returns the name of the variable
   * @return String name
   */ 
  public String getName() {
    return this.name;
  }
  
  /**
   * Set name of variable
   * @param String
   */ 
  public void setName(String name) {
    this.name = name;
  }
  
  /*
   * This method returns the string representation of the numeric value
   * @return String the returned string that represents the numeric value
   */ 
  public String toString() {
    return this.name;
  } 
  
  
  
}


