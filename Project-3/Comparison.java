/*
 * @author Andrea Tongsak
 * A class used to compare two expressions
 */ 
public class Comparison implements ExpressionBoolean {
  
  // Options for Conditional operations
  public enum Operator { LT, LTE, GT, GTE, EQ, NEQ; }
  
  // Stores operator used 
  private Operator operator;
  // Stores expression on left
  private ExpressionInt expression1;
  // Stores expression on right
  private ExpressionInt expression2;
  
  /*
   * Constructs a Comparison operation with 2 expressions and an operator
   * @param operator Operator used on 2 expressions
   * @param expression1 Expression that operator will be used on with expression2
   * @param expression2 Expression that operator will be used on with expression1
   */ 
  public Comparison (Operator operator, ExpressionInt expression1, ExpressionInt expression2) {
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
  
  /*
   * Used to return result of Operator on 2 expressions
   * @param s State for referencing variables
   */ 
  public boolean value(State s) {
    int e1Value = expression1.value(s);
    int e2Value = expression2.value(s);
    
    switch (operator) {
      case LT : return e1Value < e2Value; 
      case LTE : return e1Value <= e2Value;
      case GT : return e1Value > e2Value;
      case GTE : return e1Value >= e2Value;
      case EQ : return e1Value == e2Value;
      case NEQ : return e1Value != e2Value;
      default: break;
    }
    return false;
  }
  
  /*
   * Used to return String of expression1 + Operator + expression2
   * @return String representation of Comparison
   */ 
  public String toString() {
    String operatorString = operatorToString();
    return expression1.toString() + " " + operatorString + " " + expression2.toString(); 
  }
  
  /*
   * Convert proper Operator to String for toString method
   */
  public String operatorToString() {
    switch (operator) {
      case LT : return "<"; 
      case LTE : return "<=";
      case GT : return ">";
      case GTE : return ">=";
      case EQ : return "==";
      case NEQ : return "!=";
      default: break;
    }
    return "";
  }
}