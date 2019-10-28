
/**
 * A class used for extending to make sure all statement classes get proper toStringTabbed
 * @author <em>Andrea Tongsak</em>
 */
public class StatementType {
  /*
   * Returns conditional in string form with tabs
   * @param tabCount amount of tabs used in front of conditional
   * @return String properly tabbed
   */ 
  public String toStringTabbed(int tabCount) {
    String tabs;
    // Builder for tabs
    StringBuilder bTab = new StringBuilder();
    // Builder for output
    StringBuilder bOutput = new StringBuilder();
    
    // creates a string for the tabs
    for (int i = 0; i < tabCount; i++) {
      bTab.append("\t");
    }
    tabs = bTab.toString();
    
    // appends the tabs and string together
    for(int i = 0; i < this.toString().length(); i++) {
      bOutput.append(this.toString().charAt(i));
      if (this.toString().charAt(i) == '\n' && i != this.toString().length() - 1) {
        bOutput.append(tabs);
      }
    }
    
    return bOutput.toString();
  }
}
