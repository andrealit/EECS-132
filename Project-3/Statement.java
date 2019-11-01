
/**
 * A interface containing methods for extension.
 * @author <em>Andrea Tongsak</em>
 */
public interface Statement extends Expression {
  
  /*
   * Method stub for value needing to be tabbed
   * @param tabCount number of tabs
   * @return String properly tabbed
   */ 
  String toStringTabbed(int tabCount);
  
  /*
   * Method stub for execution
   * @param s state for variable referencing
   */ 
  void execute(State s);
  
}