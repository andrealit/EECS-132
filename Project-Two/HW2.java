// Andrea Tongsak
// EECS 132 
// Project 2 

import java.util.Arrays;

// A collection of methods that takes user input of strings and arranges them.
public class HW2 {
  
  // 1) This method takes a string and checks if in alphabetical order
  public static boolean isAlphabeticalOrder(String userInput) {
    
    // using two indexes to check two letters at a time
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
    // Postreq: all letters are in alphabetical order.
    return true;
  }
  
  // 2) This method takes a string and removes the first n occurances of a character.
  public static String removeNchars(String userInput, int numberRemove, char userLetter) {
    
    // using index to check letter
    int index = 0;
    int amountRemoved = 0;
    char charOne;
    
    StringBuilder builder = new StringBuilder(); 
    
    // The goal of this loop is to check if the index is still in the userInput
    // Prereq: any String
    // Loop invariant: The index 0 to i has removed n occurances of a character.
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
    // Postreq: all instances of character are removed
    return builder.toString();
  }
  
  // 3) This method takes two Strings and returns a String where every occurance of the second String is removed.
  public static String removeString(String userInput, String stringRemove) {
    
    // index used for checking length and comparing char
    int i = 0; 
    int k = 0;
    
    // check matching stringRemove to compareString
    boolean stringsMatch = true;
    
    StringBuilder builder = new StringBuilder(); 
    int currentPosition = 0;
    
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
            // stringsMatch continues to be true
            stringsMatch = true;
          }
        }
      }
      // If strings are the same, then move to next block with stringRemove length.
      if (stringsMatch) {
        currentPosition = currentPosition + stringRemove.length();
      } else {
        // adds the non-match char and updates position 
        builder.append(userInput.charAt(i));
        currentPosition = currentPosition + 1;
      }
      
      i = i+1;
    } 
    // Postreq: removeString is not in the new string
    
    // if not enough length, take remaining string into new string
    if (userInput.length() < (currentPosition + stringRemove.length())) {
      
      // The goal of this loop is to append the remaining letters.
      // Prereq: a userString that is smaller than stringRemove length
      // Loop invariant: index 0 to currentPosition have been appended
      while (currentPosition < userInput.length()) {
        builder.append(userInput.charAt(currentPosition));
        currentPosition = currentPosition + 1;
      }
      // Postreq: all necessary letters are appended
    }
    
    return builder.toString();
  }
  
  // 4) This method takes char and String then returns a String, where output is the same except char is shifted right
  public static String moveAllXsRight(char theChar, String userInput) {
    
    // indexes to keep track of place and number of occurances
    int i = 0;
    int j = 0;
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
              // then append theChar with move right based on match count
              builder.append(theChar);
            }
          }
        }
      }
      i = i + 1;
    }
    // Postreq: all theChar is shifted to the right
    return builder.toString();
  }
  
  // 5) This method takes a char and a two dimensional array, shifting the character "down" a row and same column
  
  public static void moveAllXsDown(char theChar, char[][] board) {
    int i = 0;
    int j = 0;
    int countMatch = 0;
    int m = 0;
    int p = 0;
    boolean needMove = true;
    
    System.out.println("The Moving Char is: " + theChar);
    System.out.println("The Original 2-Dimensional Board is: ");
    for (int k = 0; k < board.length; k++) {
      System.out.println(Arrays.toString(board[k]));
    }
     
    // The goal of this loop is to traverse through each row of the board (except the last) and search for theChar
    // Prereq: any two dimensional array
    // Loop invariant: The 2-D array from index 0 to i has shifted char down.
    while (i < board.length - 1) {
      j = 0;
      // looping through each column
      while (j < board[i].length) {
        
        if (board[i][j] == theChar) {
          m = i;
          countMatch = 0;
          
          // The goal of this loop is counting the number of matches in the array, iterating through the rows and columns
          while ((m < board.length) && (j < board[m].length) && (theChar == board[m][j])) {
            countMatch = countMatch + 1;
            m = m + 1;
          }
        
          // check the board at the position if move is needed or not
          if ((countMatch > 0) && ((i + countMatch) >= board.length)) {
            needMove = false;
          } else {
            needMove = true;
          }
          
          // if Move is needed, then move theChar down
          if (needMove) {
            
            if ((countMatch > 0) && (board[i+countMatch].length > j)) {
              // get nonmatch into cell[i, j]
              board[i][j] = board[i+countMatch][j];
              for (p = 1; p <= countMatch; p++) {
                board[i+p][j] = theChar;
              }
            }
          }
        }
        j = j + 1;
      } // end while (j < board[i].length)
      // Postreq:
      
      i = i + 1;
    } // end while (i < board.length)
    
    // Postreq: Each char has shifted down correctly in the 2D array.
    
    System.out.println("The Moving Char is: " + theChar);
    System.out.println("The New 2-Dimensional Board is: ");
    for (int q = 0; q < board.length; q++) {
      System.out.println(Arrays.toString(board[q]));
    }
    
  }
  
  // 6) This method takes a char and a two dimensional array, shifting the character "down" a row and "left" a column
  public static void moveAllXsDownLeft(char theChar, char[][] board) {
    int i = 0;
    int j = 0;
    int numRows = board.length;
    int numCols = 0;
    int p = 0;
    int q = 0;
    
    for (int v = 0; v < numRows; v++) {
      if (numCols < board[v].length) {
        numCols = board[v].length;
      }
    }
    System.out.println("The Moving Char is " + theChar);
    System.out.println("The Board has " + numRows + " rows and " );
    
    // Algorithm: 
    // 1. Skip scanning in 1st column (j == 0)
    // 2. No scanning for cells in the last row (no move down possible)
    // 3. Store value of index j for the cells that match and search for the cell to swap by scanning down south
    // 4. if the row index is still in bound then swap
    
    // A loop to traverse through the rows of the 2D array
    while (i < board.length - 1) {
      j = 1;
      // A loop to traverse through the columns of the 2D array at row i.
      while (j < board[i].length) {
        // checks if theChar is on the board
        if (board[i][j] == theChar) {
          // set p as row index to navigate
          p = i; 
          // and q as column index
          q = j; 
          
          // A loop to check if next SW column is in range. If so, swap then stop loop. Else keep moving SW.
          while (p < board.length - 1) {
            // column is in range
            if ((q-1) < board[p+1].length) {
              board[i][j] = board[p+1][q+1];
              board[p+1][q+1] = theChar;
              // set p to out of range to stop loop.
              p = board.length;
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
    
    System.out.println();
    System.out.println("The new 2D board is: ");
    for (int t = 0; t < board.length; t = t+1) {
      System.out.println(Arrays.toString(board[t]));
    }
    
  }
  
//  // 7) This method takes a char and a String, returns a String: shifting the character "down" at every /n and "right" 
//  public static void moveXDownRight(char theChar, char[][]board) {
//    
//    
//  }
  
}
