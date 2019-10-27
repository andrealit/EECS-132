
/**
 * A class representing assignment operations
 * @author <em>Andrea Tongsak</em>
 */
public class Assignment extends StatementType implements Statement {
  // Stores where expression is stored
  private Variable var; 
  // Stores what expresion is stored
  private ExpressionInt expression;
  
  /**
   * Constructor that creates an assignment instance
   */ 
  public Assignment(Variable var, ExpressionInt expression) {
    this.var = var;
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
   * Returns a string that contains the variable string value in representation
   * @return String the string representation of state values
   */ 
  public String toString() {
    return var.toString() + " := " + expression.toString() + ";\n"
    
  }
  
  
  
}