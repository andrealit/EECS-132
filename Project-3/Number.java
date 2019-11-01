/**
 * @author Andrea Tongsak
 * This class represents whole numbers
 * value takes a state as input and returns the int value of the number
 * toString returns a string representation of the numeric value of the number
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
  
  
  
}