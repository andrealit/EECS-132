
public class ConditionalStatement extends StatementType implements Statement {
  // boolean conditional for statement
  private ExpressionBoolean boolCond;
  // statement for then
  private Statement eThen;
  // statement for else
  private Statement eElse;
  
  /*
   * Constructs a conditional statement
   * @param boolCond boolean condition to decide which statement to run
   * @param eThen statement ran if boolCond is true
   * @param eElse statemen ran if boolCond is false
   */ 
  public ConditionalStatement(ExpressionBoolean boolCond, Statement eThen, Statement eElse) {
    this.boolCond = boolCond;
    this.eThen = eThen;
    this.eElse = eElse;
  }
  
  /*
   * A method executing eThen if boolCond is true and eElse if false
   * @param s State used to reference variables when needed
   */ 
  public void execute(State s) {
    if (boolCond.value(s)) {
      eThen.execute(s);
    } else {
      eElse.execute(s);
    }
  }
  
  
}