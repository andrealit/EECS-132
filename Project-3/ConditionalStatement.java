/**
 * A class used to represent conditional statements
 * @author <em>Andrea Tongsak</em>
 */
public class ConditionalStatement extends StatementType implements Statement {
  /** stores boolean conditional for statement */
  private ExpressionBoolean boolCond;
  /** stores statement for then */
  private Statement eThen;
  /** stores statement for else */
  private Statement eElse;
  
  /**
   * Constructs a conditional statement
   * @param boolCond boolean condition to decide which statement to run
   * @param eThen statement ran if boolCond is true
   * @param eElse statement ran if boolCond is false
   */ 
  public ConditionalStatement(ExpressionBoolean boolCond, Statement eThen, Statement eElse) {
    this.boolCond = boolCond;
    this.eThen = eThen;
    this.eElse = eElse;
  }
  
  /**
   * @return ExpressionBoolean returns the boolCond
   */ 
  public ExpressionBoolean getCondition() {
    return this.boolCond;
  }
  
  /**
   * @param boolCond sets the boolCond
   */ 
  public void setCondition(ExpressionBoolean boolCond) {
    this.boolCond = boolCond;
  }
  
  /**
   * @return Statement returns the then statement 
   */ 
  public Statement getThen() {
    return this.eThen;
  }
  
  /**
   * @param eThen sets the Then statement
   */ 
  public void setThen(Statement eThen) {
    this.eThen = eThen;
  }
  
  /**
   * @return Statement returns the else statement
   */ 
  public Statement getElse() {
    return this.eElse;
  }
  
  /**
   * @param eElse sets the else statement
   */ 
  public void setElse(Statement eElse) {
    this.eElse = eElse;
  }
  
  /**
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
  
  /**
   * A method returning conditional in String form
   * @return String the string version of the statement
   */ 
  public String toString() {
    StringBuilder sb = new StringBuilder("if (");
    sb.append(boolCond.toString());
    sb.append(")\n" +
              eThen.toStringTabbed(1) +
              "else\n" +
              eElse.toStringTabbed(1));
    return sb.toString();
  }
  
  
  
}