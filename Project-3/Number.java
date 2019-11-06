/**
 * This class represents whole numbers
 * @author Andrea Tongsak
 **/
public class Number extends Variable implements ExpressionInt {
  /*
   * Stores number 
   */ 
  private int number;
  
  /**
   * Constructor to replace the default constructor that takes in an input int
   * @param number the input number as given by the user to run through the methods
   **/
  public Number(int number) 
  {
    super(Integer.toString(number));
    this.number = number;
  }
  
  /**
   * This method takes in a state as an input and returns the int value of that number
   * @param s the state of the input as given by the user
   * @return int the integer value of the number given by the user
   **/
  public int value(State s) 
  {
    return this.number;
  }
  
  /**
   * Gets the number
   * @return int number stored 
   */
  public int getNumber() {
    return this.number;
  }
  
  /**
   * Sets the number
   * @param int number stored 
   */
  public void setNumber(int number) {
    this.number = number;
  }
  
  
}