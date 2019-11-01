/**
 * A class used to combine multiple statements
 * @author <em>Andrea Tongsak</em>
 */
public class CompoundStatement extends StatementType implements Statement {
  // Stores all Statements 
  private Statement[] statementArray;
  
  /*
   * The constructor of class to replace the default constructor with input array.
   * @param statementArray the varargs list of statements inputted by user
   */ 
  public CompoundStatement(Statement... statementArray) {
    this.statementArray = statementArray;
  }
  
  /*
   * Takes in a string and loops it at each iteration of the loop
   * @param s State inputted by user
   */ 
  public void execute(State s) {
    for (int i = 0; i < statementArray.length; i++) {
      statementArray[i].execute(s);
    }
  }
  
  /*
   * Takes in a string used for variable referencing
   * @return String the statement in string form
   */ 
  public String toString() {
    StringBuilder b = new StringBuilder();
    b.append("{\n");
    // for loop runs through length of array
    for (int i = 0; i < statementArray.length; i++) {
      b.append(statementArray[i].toStringTabbed(1));
    }
    b.append("}\n");
    return b.toString();
  }
}