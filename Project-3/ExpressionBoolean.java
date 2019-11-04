/**
 * @author Andrea Tongsak
 * This interface is for Expressions that will produce booleans
 **/
public interface ExpressionBoolean extends Expression {

  /**
   * Method stub for value needing to be implemented
   * @param s used for variable ref
   * @return boolean based on operator
   */
  boolean value(State s);
  
}