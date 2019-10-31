/*
 * Represent function definition in language class
 * @author Andrea Tongsak
 */ 
public class Function implements Expression {
  // stores name of function
  private String name;
  // stores body of function
  private Statement functionBody;
  // stores all param of function
  private Variable[] variableArray = {};
  
  /*
   * Constructs a function based on inputs
   * @param name what the function is named
   * @param functionBody what the function 
   * @param variableArray list of all parameters
   */
  public Function(String name, Statement functionBody, Variable[] variableArray) {
    this.name = name;
    this.functionBody = functionBody; 
    this.variableArray = variableArray;
  }
  
  /*
   * Constructor for 0 variables
   * @param name what the function is named
   * @param functionBody what the function does
   */ 
  public Function(String name, Statement functionBody) {
    this.name = name;
    this.functionBody = functionBody;
  }
  
  /*
   * @return function in String form
   */ 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("function " + name + "(");
    // for loop to run through and append the sections needed for the variable
    for (int i = 0; i < variableArray.length - 1; i++) {
      sb.append(variableArray[i].toString());
      if(i != variableArray.length - 1)
        sb.append(", ");
    }
    sb.append(")\n");
    sb.append(functionBody.toString());
    return sb.toString();
  }
  
  /*
   * Retrieves name of function
   * @return name of function
   */ 
  public String getName() {
    return this.name;
  }
  
  /*
   * Retrieves body of function
   * @return Statement of function
   */ 
  public Statement getFunctionBody() {
    return this.functionBody;
  }
  
  /*
   * Retrieves the variables of the function
   * @return variable array of the function
   */ 
  public Variable[] getVariables() {
    return this.variableArray;
  }
  
}