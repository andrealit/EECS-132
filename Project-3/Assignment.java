
/**
 * A class representing assignment operations
 * @author <em>Andrea Tongsak</em>
 */
public class Assignment extends StatementType implements Statement, ExpressionInt {
  // Stores where expression is stored
  private Variable var; 
  // Stores what expresion is stored
  private ExpressionInt expression;
  
  /**
   * Constructor that creates an assignment instance
   * @param var Variable for where the int will be assigned
   * @param e expression to be assigned to expression
   */ 
  public Assignment(Variable var, ExpressionInt expression) {
    this.var = var;
    this.expression = expression;
  }
  
  /*
   * @return Variable name of assigned int
   */ 
  public Variable getVar() {
    return this.var;
  }
  
  /*
   * @param var sets variable
   */ 
  public void setVar(Variable var) {
    this.var = var;
  }
  
  /*
   * @return ExpressionInt returns the expression assigned
   */ 
  public ExpressionInt getExpression() {
    return this.expression;
  }
  
  /*
   * @param expression sets the expression assigned
   */ 
  public void setExpression(ExpressionInt expression) {
    this.expression = expression;
  }
  
  /**
   * Updates the Assignment by updating variable with the value of expression
   * @param s the State used for variable updating
   * @return void
   */ 
  public void execute(State s) {
    s.update(var.toString(), expression.value(s));
  }
  
  /**
   * This method takes in a state as an input and returns the int value of that expression
   * @param s the state of the input as given by the user
   * @return int the integer value of the expression given by the user
   **/
  public int value(State s) 
  {
    return this.expression;
  }
  
  /**
   * Returns a string that contains the variable string value in representation
   * @return String the string representation of state values
   */ 
  public String toString() {
    return var.toString() + " := " + expression.toString() + ";\n";
    
  }
  
  
  
  
  
}