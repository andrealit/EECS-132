
public class Comparison implements ExpressionBoolean {
  
  // 
  public enum Operator { LT, LTE, GT, GTE, EQ, NEQ; }
  
  // Stores operator used 
  private Operator operator = null;
  // Stores expression on left
  private ExpressionBoolean expression1 = null;
  // Stores expression on right
  private ExpressionBoolean expression2 = null;
  // Stores whether boolean is 
  private boolean storedValue = false;
  
  public Comparison (Operator operator, ExpressionBoolean expression1, ExpressionBoolean expression2) {
    this.operator = operator;
    this.expression1 = expression1;
    this.expression2 = expression2;
  }
  
  public boolean value(State inputState) {
    /**
     * 
     */
    return storedValue;
  }
}