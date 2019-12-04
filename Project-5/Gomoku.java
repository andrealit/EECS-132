import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import java.util.List;

/**
 * The Gomoku game. Two players alternate until win. Winning the game by getting exactly five in a row.
 * Black piece moves first.
 * @author Andrea Tongsak
 */

public class Gomoku extends Application {

    /** Row in the grid. */
    private int rows;
    /** Column in the grid. */
    private int columns;
    /** The board of the game that contains JButton */
    //private BorderPane board;
    /** Two dimensional array of Buttons */
    private Button[][] grid;
    /** Whether game is won! */
    private boolean isGameWon = false;
    /** Current color */
    private Color color = Color.BLACK;
    /** the number of pieces in a row needed to win game */
    private int winNumber;
    /** represents which direction for check */
    //private Direction direction; 
    
    /** represents possible directions in the game */
    //public enum Direction { Vertical, Horizontal, RightDiag, LeftDiag; }

    private int[][] pointer = { {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1} };
    
    /**
     * 
     */ 
    public int getXDisplacement(int direction) {
      int dx = pointer[direction][0];
      return dx;
    }
    
    public int getYDisplacement(int direction) {
      int dy = pointer[direction][1];
      return dy;
    }

    /**
     * Method start must be overridden for Application
     * @param primaryStage
     * @throws Exception
     */
    public void start (Stage primaryStage) {
      
        BorderPane pane = new BorderPane();
        GridPane gridpane = new GridPane();

        // Sets default game
        // 19x19 game
        if (this.getParameters().getRaw().size() == 0) {
            this.setWinNumber(5);
            this.setRows(19);
            this.setColumns(19);
        }

        // Sets the board if given one parameter
        if (this.getParameters().getRaw().size() == 1) {
            try {
                this.setWinNumber(Integer.parseInt(this.getParameters().getRaw().get(0)));
                this.setRows(19);
                this.setColumns(19);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input: takes in integer");
            }
        }

        // Sets the board if given two parameters
        if (this.getParameters().getRaw().size() == 2) {
            try {
                this.setWinNumber(5);
                this.setRows(Integer.parseInt(this.getParameters().getRaw().get(0)));
                this.setColumns(Integer.parseInt(this.getParameters().getRaw().get(1)));
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input: takes in integer");
            }
        }

        // Sets the board if given three parameters
        if (this.getParameters().getRaw().size() == 3) {
            try {
                this.setWinNumber(Integer.parseInt(this.getParameters().getRaw().get(0)));
                this.setRows(Integer.parseInt(this.getParameters().getRaw().get(1)));
                this.setColumns(Integer.parseInt(this.getParameters().getRaw().get(2)));
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input: takes in integer");
            }
        }
   
        grid = new Button[getRows()][getColumns()];

        // iterates through rows and columns to add buttons to grid!
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                // creates a new bottom for every row and column place
               Button button = new Button();
                grid[i][j] = button;
                grid[i][j].setPrefHeight(25);
                grid[i][j].setPrefWidth(25);
                grid[i][j].setMinHeight(20);
                grid[i][j].setMinWidth(20);
                grid[i][j].setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(1,1,1,1))));
                grid[i][j].setOnAction(new ProcessClick(i, j));
                //adds the button to grid pane
                gridpane.add(grid[i][j], i, j);
                
            }
        }

        pane.setCenter(gridpane);
        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main method
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Getter for rows
     * @return rows
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Setter for rows
     * @param rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Getter for columns
     * @return columns
     */
    public int getColumns() {
        return this.columns;
    }

    /**
     * Setter for columns
     * @param columns
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * Getter for whether game won
     * @return isGameWon
     */
    public boolean getWin() {
        return isGameWon;
    }

    /**
     * Setter for whether game won
     * @param columns
     */
    public void setWin(boolean won) {
        this.isGameWon = won;
    }

    /**
     * Setter for number of tiles needed in a row
     */
    public void setWinNumber(int winNumber) {
        this.winNumber = winNumber;
    }

    /**
     * Getter for number of tiles needed in a row
     */
    public int getWinNumber() {
        return winNumber;
    }

    /**
     * Getter for current player color
     */
    public Color getPlayerColor() {
        return color;
    }

    /**
     * Setter for current player color
     */
    public void setPlayerColor(Color color) {
        this.color = color;
    }
    
    /**
     * Gets the button color
     */ 
    public Color getButtonColor(Button button) {
      List<BackgroundFill> fills = button.getBackground().getFills();
      return (Color)(fills.get(fills.size() - 1).getFill());
    }

    /**
     * Class for handling Button Click!
     */
    public class ProcessClick implements EventHandler<ActionEvent> {

        // Stores whether the button was placed in the past!
        private boolean alreadyPlaced = false;
        
        // Stores the location of the clicked button
        private int xCoor;
        
        private int yCoor;
        
        public ProcessClick (int xCoor, int yCoor) {
          this.xCoor = xCoor;
          this.yCoor = yCoor;
        }

        /**
         * Response to a button being clicked
         * @param e Action occurred
         */
        public void handle(ActionEvent e) {

            if (isGameWon) {
                return;
            }

            Button button = (Button)e.getSource();

            // if the button is open
            if (!alreadyPlaced) {
              
              button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(1)),
                                                  new BackgroundFill(getPlayerColor(), new CornerRadii(50), new Insets(2))));
              
//          if (!threeThree(getRows(), getColumns()) || !fourFour(getRows(), getColumns())) {
//            button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(1))));
//          }
//          else {
              alreadyPlaced = true;
              checkWin(button);
              alternateColor();
            }

        }

        public void alternateColor() {
            // statement switching colors
            if (getPlayerColor() == Color.BLACK) {
                setPlayerColor(Color.WHITE);
            } else {
                setPlayerColor(Color.BLACK);
            }
        }

    }

    /**
     * Checks to see if there is a three-three. Player can't make a move that simultaneously creates two or more groups
     * of three
     * @param row The row of the click
     * @param column The column of the click
     * @return The boolean stating whether there is a three three
     */
    public boolean threeThree(Button button) {
      // sets number for 3-3 rule
      int max3 = getWinNumber() - 2;
      int counter = 0;
      boolean threeThree = false;
      
      // counts the number of pieces in every direction
      for (int direction = 1; direction <= 4; direction++) {
        // counts the number of threes created by pieces of the same color
        if (count4Directions(direction) + 1 == max3) {
          counter++;
        }
      }
      
      // when the counter of the number of directions created with the max is 2 or more groups, set boolean to true 
      
      if (threeThree = true) {
        System.out.println("This violates the three-three rule! Try a different spot.");
      }
      

      return threeThree;
    }

    /**
     * Checks to see if there is a four Four, regardless of open spaces
     * @param row The row of the click
     * @param column The column of the click
     * @return The boolean representation of whether there was a four four.
     */
    public boolean fourFour(Button button) {
      // sets number for 4-4 rule
      int max4 = getWinNumber() - 1;
      int counter = 0;
      boolean fourFour = false;

      // counts the number of pieces in every direction
      for (int direction = 1; direction <= 4; direction++) {
        // counts the number of fours created by pieces of the same color
        if (count4Directions(direction) + 1 == max4) {
          counter++;
        }
      }
      
      // when the counter of the number of directions created with the max is 2 or more groups, set boolean to true
      
      if (fourFour = true) {
        System.out.println("This violates the four-four rule! Try a different spot.");
      }
      
      return fourFour;
    }

    /**
     * Checks to see if there is a game won, or 5 pieces of the same color in a row.
     * @param row The row of the click.
     * @param column The column of the click.
     * @return The boolean representation of game won.
     */
    public void checkWin(Button button) {
      // stores the number of same color pieces
      int counter = 0;
      
      // check if not empty, while having a counter 
      if (!isEmpty(button)) {
        for (int i = 0; i < 4; i++ ) {
          counter = count4Directions(i);
        }
      }
      
      // when the win number equals the pieces in a row
      if (getWinNumber() == counter) {
        isGameWon = true;
      }
      
      declareWinner();
    }
    
    /**
     * Declares victory!
     */ 
    public void declareWinner () {
      if (isGameWon) {
        // when the game is won and the last piece placed was BLACK
        if (getPlayerColor() == Color.BLACK) {
          System.out.println("Black is the winner!");
        }
        
        // when the game is won and the last piece placed was WHITE
        if (getPlayerColor() == Color.WHITE) {
          System.out.println("White is the winner!");
        }
      }
    }


    /**
     * This method returns the number of pieces of the same color in a row including the button in params.
     * @param board The 2D array of Buttons representing the board
     * @param row The row position of the currently played piece
     * @param column The column position of the currently played piece
     * @param direction The direction to search (vert, horiz, right diag, left diag)
     * @return The number of consecutive same color pieces counting the first starting one
     */
    public int numberInLine (Button[][] grid, int row, int column, int direction) {
      int dx = getXDisplacement(direction); 
      int dy = getYDisplacement(direction);
      int counter = 0;
      try {
      Color color = getButtonColor(grid[row][column]);
      // precondition: the dx and dy are set correctly
      // ensures that while counting, does not exit the board
      
        // makes sure is counting pieces of same color
        while (getButtonColor(grid[row+dx][column+dy]) == color) {
          row += dx;
          column += dy;
          counter++;
        }
        
        // doesn't account for the button you're on!
        return counter;
        // postcondition: counted same color 
      } catch (ArrayIndexOutOfBoundsException e) {
        return counter;
      }
      
      
    }
    
    /**
     * This method counts the number of buttons in a row starting from the given button
     * @param button
     * @return counter the number of buttons in row
     */ 
    public int count4Directions (int direction) {
      // does account for the button you're on (starts at 1)
      int counter = 1; 
      
      counter += numberInLine(getGrid(), getRows(), getColumns(), direction);
      counter +=  numberInLine(getGrid(), getRows(), getColumns(), direction + 4);

      return counter;
    }
    
    /**
     * Checks whether button is empty or not
     * @param button
     * @return boolean
     */ 
    public boolean isEmpty(Button button) {
      if (getButtonColor(button) == Color.GREEN) {
        return true;
      } else {
        return false;
      }
    }
    
    /**
     * Determines if there is an open space following the input direction at position row, column on the board. 
     * Directions consists of up, right, down, left, and the four diagonals.
     * @param board The two D array of buttons representing the board of the game.
     * @param row The position for the row of the currently played piece.
     * @param column The position for the column of the currently played piece.
     * @param direction The direction to search (up, right, down, left, and the four diagonals).
     * @return The boolean representation if there is an open space following the direction starting at the row, column on the board.
     */
    public boolean isOpen (Button[][] board, int row, int column, int direction) {
      // TO DO
      return true;
    }

    /**
     * Helper method returns the grid for testing
     * @return The grid of Buttons
     */
    public Button[][] getGrid() {
        return grid;
    }

}
