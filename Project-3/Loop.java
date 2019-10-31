
/*
 * A class representing while loops
 */ 
public class Loop extends StatementType implements Statement {
  // Stores boolean condition for statement
  private ExpressionBoolean boolCond = null;
  // Stores statement 
  private Statement loopBody = null;
  
  /*
   * Construct a loop based on boolean condition and body of loop
   * @param boolCond used to check if loop runs again
   * @param loopBody executed for every loop run
   */ 
  public Loop (ExpressionBoolean boolCond, Statement loopBody) {
    this.boolCond = boolCond;
    this.loopBody = loopBody;
  }
  
  /*
   * Runs the loop
   * @param s State used for variable referencing
   */ 
  public void execute (State s) {
    while (boolCond.value(s) == true) {
      loopBody.execute(s);
    }
  }
  
  /*
   * String representation of what is happening in the execute method
   * @return the loop in String form
   */
  public String toString() {
    StringBuilder b = new StringBuilder();
    b.append("while (" + boolCond.toString() + ")\n" + loopBody.toStringTabbed(1));
    return b.toString();
  }
  
}