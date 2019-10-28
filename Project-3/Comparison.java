/*
 * @author Andrea Tongsak
 * A class used to compare two expressions
 */ 
public class Comparison implements ExpressionBoolean {
  
  public enum Operator { LT, LTE, GT, GTE, EQ, NEQ; }
  
  // Stores operator used 
  private Operator operator = null;
  // Stores expression on left
  private ExpressionBoolean expression1 = null;
  // Stores expression on right
  private ExpressionBoolean expression2 = null;
  
  /*
   * Constructs a Comparison operation with 2 expressions and an operator
   * @param operator Operator used on 2 expressions
   * @param expression1 Expression that operator will be used on with expression2
   * @param expression2 Expression that operator will be used on with expression1
   */ 
  public Comparison (Operator operator, ExpressionBoolean expression1, ExpressionBoolean expression2) {
    this.operator = operator;
    this.expression1 = expression1;
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
   * @return String representation of 
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
