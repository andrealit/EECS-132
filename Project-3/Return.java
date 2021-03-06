
/**
 * A class representing return expressions in functions
 * @author <em>Andrea Tongsak</em>
 */ 
public class Return extends StatementType implements Statement {
  
  // Stores the expression
  private ExpressionInt expression;
  
  /*
   * A constructor that takes in an expression and replaces the default constructor
   * @param expression the given input expression by the user to run through methods
   */ 
  public Return (ExpressionInt expression) {
    this.expression = expression;
  }
  
  /*
   * Sets the expression assigned
   * @param expression 
   */ 
  public void setExpression(ExpressionInt expression) {
    this.expression = expression;
  }
  
  /*
   * returns assigned int
   * @return ExpressionInt 
   */ 
  public ExpressionInt getExpression() {
    return this.expression;
  }

  /*
   * This method updates the state to set the value of a variable return
   * @param s the state of the input as given by the user
   */
  public void execute (State s) {
    s.update("return", expression.value(s));
  }
  
  /*
   * This method returns a string that is a visual representation of what is happening in execute method
   * @return String the Return expression in String form
   */
  public String toString() {
    return "return " + expression.toString() + ";\n";
  }
  
}