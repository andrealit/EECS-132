// Andrea Tongsak
// EECS 132 
// Project 2 


// A collection of methods that takes user input of strings and arranges them.
public class HW2 {
  
  // sorts through userInput and checks if in alphabetical order
  public static boolean isAlphabeticalOrder(String userInput) {
    
    // using two indexes to check two letters at a time
    int frontLetter = 0;
    int backLetter = frontLetter+1;
    
    while (frontLetter < userInput.length()-1 && backLetter < userInput.length()) {
      if (!Character.isLetter(userInput.charAt(frontLetter))) {
        frontLetter = frontLetter + 1;
      }
      else if (!Character.isLetter(userInput.charAt(backLetter))) {
        backLetter = backLetter + 1;
      }
      else if (Character.toUpperCase(userInput.charAt(backLetter)) < Character.toUpperCase(userInput.charAt(frontLetter))) {
        System.out.println("false");
        return false;
      }
      else {
        frontLetter = frontLetter + 1;
        backLetter = backLetter + 1;
      }
    }
    System.out.println("true");
    return true;
  }
  
  // takes a string and removes the first n occurances of a character.
  public static String removeNchars(String userInput, int numberRemove, char userLetter) {
    
    // using index to check letter
    int index = 0;
    int amountRemoved = 0;
    char charOne;
    
    StringBuilder builder = new StringBuilder(); 
     
    while (index < userInput.length()) {

      charOne = userInput.charAt(index);
      
      if (charOne != userLetter) {
        builder.append(userInput.charAt(index));
      } else {
        if (amountRemoved < numberRemove) {
          amountRemoved += 1;
        } else {
          builder.append(charOne);
        }
      }
      
      index = index + 1;
    }
    
    return builder.toString();
  }
  
  // takes two string and 
  public static String removeString() {
    return "";
  }
  
  public static String moveAllXsRight(char shiftedLetter, String userInput) {
    return "";
  }
  
  public static void moveAllXsLeft() {
  }
  
}