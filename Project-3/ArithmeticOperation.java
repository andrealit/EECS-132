/*
 * @author Andrea Tongsak
 * A class used to represent arithmetic operations 
 */ 
public class ArithmeticOperation implements ExpressionInt {
  
  // options for Arithmetic operations
  public enum Operator { Add, Sub, Mult, Div, Rem; }
  
  // Stores which operator for action
  private Operator operator;
  // Stores expression on left
  private ExpressionInt expression1;
  // Stores expression on right
  private ExpressionInt expression2;
  
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
  
  /*
   * @return Operator returns the operator
   */ 
  public Operator getOperator() {
    return this.operator;
  }
  
  /*
   * @param Operator sets operator 
   */ 
  public void setOperator(Operator operator) {
    this.operator = operator;
  }
  
  /*
   * @return ExpressionInt returns the left hand expression
   */ 
  public ExpressionInt getExpression1() {
    return this.expression1;
  }
  
  /*
   * @param expression1 sets the left hand expression
   */ 
  public void setExpression1(ExpressionInt expression1) {
    this.expression1 = expression1;
  }
  
  /*
   * @return ExpressionInt returns the left hand expression
   */ 
  public ExpressionInt getExpression2() {
    return this.expression2;
  }
  
  /*
   * @param expression2 sets the left hand expression
   */ 
  public void setExpression2(ExpressionInt expression2) {
    this.expression2 = expression2;
  }
  
  /**
   * Takes in s and returns the value executed by operator
   * @param s the state of the input given
   */
  public int value(State s) {
    int e1Value = expression1.value(s);
    int e2Value = expression2.value(s);
    
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