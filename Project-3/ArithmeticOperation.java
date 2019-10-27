
public class ArithmeticOperation implements ExpressionInt {
  
  // options for Arithmetic operations
  public enum Operator { Add, Sub, Mult, Div, Rem; }
  
  // Stores which operator for action
  private Operator operator = null;
  // Stores expression on left
  private ExpressionInt expression1 = null;
  // Stores expression on right
  private ExpressionInt expression2 = null;
  
  /*
   * Creates an new instance of ArithmeticOperation 
   * @param operator - symbol compares the expressions 
   * @param expressionOne - the left hand of the expression
   * @param expressionTwo - the right hand of the expression
   */ 
  public ArithmeticOperation(Operator operator, ExpressionInt expression1, ExpressionInt expression2) {
    this.operator = operator;
    this.expression1 = expression1;
    this.expression2 = expression2;
  }
  
  /**
   * Takes in inputState and returns 
   * @param inputState the state of the input given
   */
  public int value(State inputState) {
    int e1Value = expression1.value(inputState);
    int e2Value = expression2.value(inputState);
    
    switch (operator) {
      
      case Add : return e1Value + e2Value;
      case Sub : return e1Value - e2Value;
      case Mult : return e1Value * e2Value;
      case Div : return e1Value / e2Value;
      case Rem : return e1Value % e2Value;
      default: break;
    }
    return 0;
  }
  
  /*
   * Used to return String of e1 + Operator + e2
   * @return String returns a string representation of expressions and operation
   */
  public String toString() {
    String operatorString = operatorToString();
    return expression1.toString() + " " + operatorString + " " + expression2.toString();
  }
  
  /*
   * Converts operator into a String for toString
   * @return String returns string form of operator
   */
  private String operatorToString() {
    switch (operator) {
      case Add : return "+";
      case Sub : return "-";
      case Mult : return "*";
      case Div : return "/";
      case Rem : return "%";
      default: break;
    }
    return "";
  }
  
  
}
