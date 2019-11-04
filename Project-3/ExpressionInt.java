/**
 * @author Andrea Tongsak
 * This interface is for Expressions that produce ints
 **/
public interface ExpressionInt extends Expression {

  /**
   * Method stub for value needing to be implemented
   * @param s used for variable ref
   * @return int based on operator
   */ 
  int value(State s);
  
}