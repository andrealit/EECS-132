// Andrea Tongsak
// EECS 132 
// Project 2 

// A collection of methods that takes user input of strings and arranges them.
public class HW2 {
  
  // 1) takes a string and checks if in alphabetical order
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
        return false;
      }
      else {
        frontLetter = frontLetter + 1;
        backLetter = backLetter + 1;
      }
    }
    return true;
  }
  
  // 2) takes a string and removes the first n occurances of a character.
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
  
  // 3) takes two Strings and returns a String where every occurrence of the second input String is removed.
  public static String removeString(String userInput, String stringRemove) {
    
    // index used for checking length
    int i = 0; 
    
    // index used for building compareString
    int j = 0;
    
    // index used for comparing the chars in strings
    int k = 0;
    
    // check for matching stringRemove to compareString
    boolean stringsMatch = true;
    
    // used for final output
    StringBuilder builder = new StringBuilder(); 
    
    // which index the substring comparision is at
    int currentPosition = 0;
    
    // used for comparing the String that forms at each index from userInput
    StringBuilder compareString = new StringBuilder();
    
    // loop building the compareString and checking it with stringRemove & checks there is room in the string to compare
    while ((i < userInput.length()) && (userInput.length() >= (currentPosition + stringRemove.length()))) {
      // "compareString" is same length as stringRemove
      j = 0;
      while (j < stringRemove()) {
        // builds the substring "compareString" from userInput. start at currentPosition for userInput
        compareString.append(userInput.charAt(currentPosition + 1));
        j = j + 1;
      }
      
      // compare the two strings if they are the same or not
      for (k = 0; k < stringRemove.length(); k = k+1) {
        if (compareString.charAt(k) != stringRemove.charAt(k)) {
          stringsMatch = false;
        } else {
          // checks first if the char from compareString and stringRemove have been matching
          if (stringsMatch == true) {
            // allow stringsMatch to continue to be true
            stringsMatch = true;
          }
        }
      }
      
      // if strings are the same, then move to next block with stringRemove length, else char goes to builder
      if (stringsMatch) {
        currentPosition = currentPosition + stringRemove.length();
      } else {
        builder.append(userInput.charAt(i));
        currentPosition = currentPosition + 
      }
    }
    

    return builder.toString();    
      
  }
  
  // 4) takes a char and a String then returns a String, where output is the same except character is shifted to right
  public static String moveAllXsRight(char theChar, String userInput) {
    
    // indexes to keep track of place and number of occurances
    int i = 0;
    int j = 0;
    int countMatch = 0;
    
    StringBuilder builder = new StringBuilder();
    
    while (i < userInput.length()) {
      
      // checks if a match
      if (theChar != userInput.charAt(i)) {
        builder.append(userInput.charAt(i));
      } else {
        // match, but it is at the last place in the String
        if (i == userInput.length() - 1) {
          // append this char to builder
          builder.append(userInput.charAt(i));
        } else {
          // match, but is is NOT at the last place
          
          // checks if next Char is theChar
          if (theChar != userInput.charAt(i+1)) {
            // shift the order of append
            builder.append(userInput.charAt(i+1));
            builder.append(userInput.charAt(i));
            i = i + 1;
          } else {
            // both i and i+1 are Char, so keep counting
            countMatch = 0;
            
            // while not out of String
            while ((i < userInput.length()) && (theChar == userInput.charAt(i))) {
              // updates the countMatch and moves index
              countMatch = countMatch + 1;
              i = i + 1;
            }
            
            // checks first if i is out of bounds
            if (i < userInput.length()) {
              // append the non-match chars first
              builder.append(userInput.charAt(i));
            }
            
            for (j = 1; j <= countMatch; j = j+1) {
              // then append theChar with move right based on match count
              builder.append(theChar);
            }
            
          }
        }
      }
      i = i + 1;
    }
    
    return builder.toString();
  }
  
  // 5) takes a char and a two dimensional array and returns nothing
  public static void moveAllXsDown(char theChar, char[][] board) {
    
  }
  
  // 6) takes a char and a two dimensional array 
  public static void moveAllXsDownLeft(char theChar, char[][] board) {
    
    
  }
  
  
}