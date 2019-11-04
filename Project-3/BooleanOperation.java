/**
 * A class representing Boolean Operations
 * @author <em>Andrea Tongsak</em>
 */ 
class BooleanOperation {
  /**
   * options for Boolean operations
   */
  public enum Operator { And, Or; }
  
  // Stores which operator for action
  private Operator operator;
  // Stores expression 1
  private ExpressionBoolean expression1;
  // Stores expression 2
  private ExpressionBoolean expression2;
  
  /*
   * Construct Operation with 2 expressions and Operator
   * @param operator The specific operator used
   * @param expression1 The left hand of the expression
   * @param expression2 The right hand of the expression
   */ 
  public BooleanOperation(Operator operator, ExpressionBoolean expression1, ExpressionBoolean expression2) {
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
   * @return ExpressionBoolean returns the left hand expression
   */ 
  public ExpressionBoolean getExpression1() {
    return this.expression1;
  }
  
  /*
   * @param expression1 sets the left hand expression
   */ 
  public void setExpression1(ExpressionBoolean expression1) {
    this.expression1 = expression1;
  }
  
  /*
   * @return ExpressionBoolean returns the left hand expression
   */ 
  public ExpressionBoolean getExpression2() {
    return this.expression2;
  }
  
  /*
   * @param expression2 sets the left hand expression
   */ 
  public void setExpression2(ExpressionBoolean expression2) {
    this.expression2 = expression2;
  }
  
  /*
   * Takes in s and returns the value executed by operator
   * @param s The state of input given
   */ 
  public boolean value(State s) {
    boolean e1Value = expression1.value(s);
    boolean e2Value = expression2.value(s);
    
    switch (operator) {
      case And : return e1Value && e2Value;
      case Or : return e1Value || e2Value;
      default: break;
    }
    return true;
  }
  
  /*
   * Used to convert String of e1 + Operator + e2
   * @return String of expressions and operator
   */ 
  public String toString() {
    String operatorString = operatorToString();
    return expression1.toString() + " " + operatorString + " " + expression2.toString();
  }
  
  /*
   * Convert operator to String for toString
   */ 
  private String operatorToString() {
    switch (operator) {
      case And : return "&&";
      case Or : return "||";
      default: break;
    }
    return "";
  }
  
}