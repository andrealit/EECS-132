/**
 * @author Andrea Tongsak
 * This class represents whole numbers
 * value takes a state as input and returns the int value of the number
 * toString returns a string representation of the numeric value of the number
 **/
public class Number implements Expression {
  /*
   * Stores number 
   */ 
  private int inputNum = 0;
  
  /**
   * Constructor to replace the default constructor that takes in an input int
   * @param inputNum the input number as given by the user to run through the methods
   **/
  public Number(int inputNum) 
  {
    this.inputNum = inputNum;
  }
  
  /**
   * This method takes in a state as an input and returns the int value of that number
   * @param inputState the state of the input as given by the user
   * @return int the integer value of the number given by the user
   **/
  public int value(State inputState) 
  {
    return inputState.lookup("" + inputNum);
  }
  
  
  
}