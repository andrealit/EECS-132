/**
 * Represent function call in language class
 * @author Andrea Tongsak
 */ 
public class FunctionCall implements ExpressionInt {
  /** stores the functions used */
  private Function function;
  /** stores all variable inputs */
  private ExpressionInt[] variableInputs;
  /** stores all variable params */
  private Variable[] variableArray;
  /** stores function process */
  private Statement functionBody;
  /** stores state */
  private State state;
  
  /**
   * Constructs function call
   * @param function used to return value
   * @param variableInputs fills function parameters
   */ 
  public FunctionCall(Function function, ExpressionInt... variableInputs) {
    this.function = function;
    this.variableInputs = variableInputs;
    this.variableArray = function.getVariables();
    this.functionBody = function.getFunctionBody();
  }
  
  /**
   * Construct function call when no params for function exist
   * @param function used to return value
   */ 
  public FunctionCall(Function function) {
    this.function = function;
    this.variableArray = function.getVariables();
    this.functionBody = function.getFunctionBody();
  }
  
  /**
   * Return value after running function
   * @param s State used for referencing
   * @return int value after function
   */ 
  public int value(State s) {
    state = new State();
    for (int i = 0; i < variableArray.length; i++) {
      state.update(variableArray[i].toString(), variableInputs[i].value(s));
    }
    
    functionBody.execute(state);
    return state.lookup("return");
  }
  
  /**
   * Returns function call in String form
   * @return String function call
   */ 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(function.getName() + "(");
    for (int i = 0; i < variableArray.length; i++) {
      sb.append(variableInputs[i].toString());
      if(i != variableArray.length - 1)
        sb.append(", ");
    }
    sb.append(")");
    return sb.toString();
  }
  
}