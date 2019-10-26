// Andrea Tongsak
// EECS 132 
// HW 2 

import java.util.Arrays;

// A collection of methods that takes user input of strings or arrays and arranges them.
public class HW2 {
  
  // 1) This method takes a string and checks if in alphabetical order
  public static boolean isAlphabeticalOrder(String userInput) {
    int frontLetter = 0;
    int backLetter = frontLetter+1;
    
    // The goal of this loop is to check if the string is in alphabetical order by comparing char values
    // Prereq: any String
    // Loop invariant: The String from index 0 to i is in alphabetical order.
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
  
  // 2) This method takes a string and removes the first n occurances of a character.
  public static String removeNchars(String userInput, int numberRemove, char userLetter) {
    int index = 0;
    int amountRemoved = 0;
    // character from userInput checked every time
    char charOne;
    
    StringBuilder builder = new StringBuilder(); 
    
    // This loop checks if the index is still in the userInput by iterating through the String
    // Prereq: any String
    // Loop invariant: The index 0 to i has removed n occurances of a character.
    while (index < userInput.length()) {

      charOne = userInput.charAt(index);
      
      // checks if charOne is the letter
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
  
  // 3) This method takes two Strings and returns a String where every occurance of the second String is removed.
  public static String removeString(String userInput, String stringRemove) {
    int i = 0; 
    int k = 0;
    
    // check matching stringRemove to compareString
    boolean stringsMatch = true;
    // keeps track of currentPosition in String
    int currentPosition = 0;
    
    StringBuilder builder = new StringBuilder(); 
    
    // condition for asking to to remove an empty string
    if (stringRemove.equals("")) {
      builder.append(userInput);
    } else {
      
      // The goal of the loop is to compare strings and build new string while there is room in the string to compare
      // Prereq: a String
      // Loop invariant: The index 0 to i does not contain stringRemove.
      while ((i < userInput.length()) && (userInput.length() >= (currentPosition + stringRemove.length()))) {
        
        // compare the two strings if they are the same or not
        stringsMatch = true;
        for (k = 0; k < stringRemove.length(); k = k+1) {
          if (userInput.charAt(currentPosition + k) != stringRemove.charAt(k)) {
            stringsMatch = false;
          } else {
            // checks first if the char from compareString and stringRemove have matched previously
            if (stringsMatch == true) {
              // stringsMatch continues true, meaning the word matching is continued
              stringsMatch = true;
            }
          }
        }
        
        // If strings are the same, then move to next block with stringRemove length.
        if (stringsMatch) {
          currentPosition = currentPosition + stringRemove.length();
        } else {
          // adds the non-match char and updates position 
          builder.append(userInput.charAt(currentPosition));
          currentPosition = currentPosition + 1;
        }
        
        i = i+1;
      }
      // end while (i<userInput.length)
      
      // if not enough length, take remaining string into new string
      if (userInput.length() < (currentPosition + stringRemove.length())) {
        
        // This loop is to append the remaining letters without stringRemove.
        while (currentPosition < userInput.length()) {
          builder.append(userInput.charAt(currentPosition));
          currentPosition = currentPosition + 1;
        }
      }
    }
    return builder.toString();
  }
  
  // 4) This method takes char and String then returns a String, where output is the same except char is shifted right
  public static String moveAllXsRight(char theChar, String userInput) {
    int i = 0;
    int j = 0;
    // keep track of number of word occurances
    int countMatch = 0;
    
    StringBuilder builder = new StringBuilder();
    
    // The purpose of this loop is go through the userInput string checking for "theChar" and shift to the right
    // Prereq: any String
    // Loop invariant: The String from index 0 to i shifted "theChar" to the right.
    while (i < userInput.length()) {
      
      // checks if a match
      if (theChar != userInput.charAt(i)) {
        builder.append(userInput.charAt(i));
      } else {
        // match, but it is at the last place in the String
        if (i == userInput.length() - 1) {
          builder.append(userInput.charAt(i));
        } else {
          // match, but is is NOT at the last place
          
          // checks if next Char is theChar
          if (theChar != userInput.charAt(i+1)) {
            // switches the order of append
            builder.append(userInput.charAt(i+1));
            builder.append(userInput.charAt(i));
            i = i + 1;
          } else {
            // both i and i+1 are Char, so keep count
            countMatch = 0;
            
            // This goal of this loop is to move the index and update the count match. 
            while ((i < userInput.length()) && (theChar == userInput.charAt(i))) {
              // updates the countMatch and moves index
              countMatch = countMatch + 1;
              i = i + 1;
            }
            
            // checks if i is out of bounds
            if (i < userInput.length()) {
              // append the non-match chars first
              builder.append(userInput.charAt(i));
            }
            
            // The goal of this loop is to append theChar in correct place 
            for (j = 1; j <= countMatch; j = j+1) {
              // append theChar shifted right
              builder.append(theChar);
            }
          }
        }
      }
      i = i + 1;
    }
    return builder.toString();
  }
  
  // 5) This method takes a char and a two dimensional array, shifting the character "down" a row and same column
  public static void moveAllXsDown(char theChar, char[][] board) {

    // A loop that iterates through rows bottom up, ignoring bottom rows
    for (int i = board.length - 2; i >= 0; i = i - 1){
      // A loop that iterates through columns 
      for (int j = board[i].length - 1; j > 0; j = j - 1){
        // looking for theChar
        if (board[i][j] == theChar && j < board[i+1].length){
          board[i][j] = board[i+1][j];
          board[i+1][j] = theChar;
        }
      }
    }
  }
  
  // 6) This method takes a char and a two dimensional array, shifting the character "down" a row and "left" a column
  public static void moveXDownLeft(char theChar, char[][] board) {
    int i = 0;
    int j = 0;
    int p = 0;
    int q = 0;
    // checks if row is in range
    boolean inRange = true;
    
    // A loop to traverse through the rows of the 2D array
    // Prereq: any two dimensional array
    // Loop invariant: The 2-D array from index 0 to i has shifted char down and left.
    while (i < board.length - 1) {
      // skip scanning column 0
      j = 1;
      
      // A loop to traverse through the columns at row i.
      while (j < board[i].length) {
        // checks if theChar is on the board
        if (board[i][j] == theChar) {
          // save row and column index to navigate
          p = i; 
          q = j; 
          
          // reset inRange
          inRange = true;
          
          // A loop to check if next SW column is in range. If so, swap and stop loop, else keep moving SW.
          while (p < board.length - 1 && inRange == true) {
            
            // column is in range
            if ((q-1) < board[p+1].length) {
              
              // switches the places
              board[i][j] = board[p+1][q-1];
              board[p+1][q-1] = theChar;
              
              // set to inRange to false to stop loop.
              inRange = false;
            } else {
              p = p + 1;
              q = q - 1;
            }
          }
          
        } 
        j = j+1;
      } 
      i = i+1;
    }
  }
  
  // 7) This method takes a char and a String, returns a String: shifting the character "down" at every /n and "right" 
  public static String moveXDownRight(char theChar, String userInput) {
    int i = 0;
    int j = 0;
    int p = 0;
    // lastPositionChar is the last place the char is at in index before moving
    int lastPositionChar = 0;
    // position1 is a placeholder for position
    int position1 = 0;
    // numLines keeps count of the /n
    int numLines = 0;
    // theCharPosition tracks the char that shifts
    int theCharPosition = 0;
    // lastEOLPosition tracks the end of line index 
    int lastEOLPosition = 0; 
    // eolPosition keeps track of the end of line during loop of getting info from string
    int eolPosition = 0;
    // keyPosition is the place you are moving
    int keyPosition = 0;
    
    // holds EOL positions of string userInput
    StringBuilder eolMap = new StringBuilder();
    // holds impacted char positions in string to move
    StringBuilder positionMap = new StringBuilder();
    // new string to build
    StringBuilder builder = new StringBuilder();
    
    // This loop collects information on string and save end of line in a string map (EOL map!)
    while (i < userInput.length()) {
      
      if (userInput.charAt(i) == '\n') {
        numLines++;
        eolMap.append((char)(i));
        lastEOLPosition = i;
      }
      
      if (userInput.charAt(i) == theChar) {
        theCharPosition = i;
      }
      
      i = i+1;
    }
    
    // Check first if theChar has open location to "land" in the new string
    // If there is no place to "land" then copy userInput to new string. Return the new string, and exit the code.
    lastPositionChar = 1 + lastEOLPosition + numLines;
    if (lastPositionChar >= userInput.length()) {
      // This loop appends the characters from the string in the correct order
      for (i = 0; i < userInput.length(); i = i + 1) {
        builder.append(userInput.charAt(i));
      }
      return builder.toString();
    }
    
    // This loop is used to build cells without the new line, swap position map: positionMap
    for (p = 0; p < eolMap.length(); p = p+1) {
      eolPosition = (int)eolMap.charAt(p);
      if ((userInput.charAt(eolPosition + p + 2)) != '\n') {
        positionMap.append((char)(eolPosition + p + 2));
      }
    }
    
    // echo out positionMap
    System.out.println();
    for(int x = 0; x< positionMap.length(); x++) {
      keyPosition = (int)positionMap.charAt(x);
      System.out.println("keyPosition" + x + " = " + keyPosition);
    }
    System.out.println();
    
    // Building new string and swapping!
    
    // (1) This loop take all chars before theChar position into the new string.
    int currentPosition = 0;
    for (i = 0; i < theCharPosition; i = i + 1) {
      builder.append(userInput.charAt(i));
      currentPosition = currentPosition + 1;
    }
    
    int position2 = 0;
    // (2) use positionMap data to move chars into the new string
    // This loop traverses through positionMap and assigns position1 to the correct position
    for (i = 0; i < positionMap.length(); i = i+1) {
      
      position1 = (int)positionMap.charAt(i);
      builder.append(userInput.charAt(position1));
      currentPosition = currentPosition + 1;
      
      if ((i + 1) < positionMap.length()) {
        position2 = (int)positionMap.charAt(i+1);
        
        // This loop traverses through the new position and appends all other letters
        for (j = currentPosition; j < position2; j = j+1) {
          if (userInput.charAt(j) != theChar) {
            builder.append(userInput.charAt(j));
          }
          currentPosition = currentPosition + 1;
        }
        // swap chars between pos1 and pos 2
        
        builder.append(userInput.charAt(position2));
        System.out.println(builder.toString());
        currentPosition = currentPosition + 1;
      }
    }
    
    // (3) append theChar into the new string
    builder.append(theChar);
    currentPosition = currentPosition + 1;
    
    // (4) if there are any chars left in the string, append them
    if (currentPosition < userInput.length()) {
      for (i = currentPosition; i < userInput.length(); i = i+1) {
        builder.append(userInput.charAt(i));
        currentPosition = currentPosition + 1;
      }
    }
    
    // Echo out stuff
    System.out.println("The moving char is: " + theChar);
    System.out.println("The String has " + numLines + " lines.");
    System.out.println("theCharPosition in the string = " + theCharPosition);
    System.out.println("lastEOLposition = " + lastEOLPosition);
    System.out.println();
    System.out.println("Original Output String: ");
    System.out.println(userInput.toString());
    System.out.println();
    System.out.println("Result Output String: ");
    System.out.println(builder.toString());
    
    // return the new string
    return builder.toString();
    
  }
  
}
