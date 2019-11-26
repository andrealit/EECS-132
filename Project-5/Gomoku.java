import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

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
    private boolean isGameWon;
    /** Current player */
    private int player = 1;

    /**
     * Creates a new rows
     */ 
    public Gomoku() {
      this(19,19);
    }
    
    /**
     * Creates a new rows by column grid with green background
     * @param rows
     * @param columns
     */ 
    public Gomoku(int rows, int columns) {
      this.rows = rows;
      this.columns = columns;
      
      BorderPane pane = new BorderPane();
      GridPane gridpane = new GridPane();
      isGameWon = false;
      
      
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          gridpane.add(new Button(), i, j);
          
        }
      }
      
      pane.setCenter(gridpane);
      Scene scene = new Scene(pane);
      
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    
    /**
     * Method start must be overridden for Application
     * @param primaryStage
     * @throws Exception
     */
    public void start (Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        GridPane gridpane = new GridPane();
        rows = 19;
        columns = 19;
        
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < columns; j++) {
            gridpane.add(new Button(), i, j);
            board[i][j].setText(null);
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
     * Response to a button being clicked
     * @param e Action occurred
     */ 
    public void actionPerformed(ActionEvent e) {
      if (isGameWon) {
        
      }
    }

    /**
     * This method returns the number of pieces of the same color in a row including the button given to the method.
     * @param board The 2D array of Buttons representing the board
     * @param row The row position of the currently played piece
     * @param column The column position of the currently played piece
     * @param direction The direction to search (up, down, right, left, and four diagonals)
     * @return The number of consecutive same color pieces counting the first starting one
     */
    public int numberInLine (Button[][] board, int row, int column, String direction) {
        int r = row;
        int c = column;
        int numberInLine = 1;
        boolean exit = false;

        if (direction.equals("up")) {
            // up
            for (int i = row; ((i > 0) && exit == false); i--) {
                if ((board[row][column].getBackground().equals(board[i-1][column].getBackground())) && exit == false){

                    if (board[i-1][column].getBackground().equals(board[i][column].getBackground()) == false) {
                        exit = true;
                    } else {
                        numberInLine++;
                    }
                }
            }
        }
        else if (direction.equals("right")) {
            // right
            for (int i = column; ((i < this.columns-1) && exit == false); i++) {
                if ((board[row][column].getBackground().equals(board[row][i+1].getBackground())) && exit == false) {

                    if (board[row][i+1].getBackground().equals(board[row][i].getBackground()) == false) {
                        exit = true;
                    } else {
                        numberInLine++;
                    }
                }
            }
        }

        else if (direction.equals("down")) {
            // down
            for (int i = row; ((i > this.rows-1) && exit == false); i++) {
                if ((board[row][column].getBackground().equals(board[i+1][column].getBackground())) && exit == false) {

                    if (board[i+1][column].getBackground().equals(board[i][column].getBackground()) == false) {
                        exit = true;
                    } else {
                        numberInLine++;
                    }
                }
            }
        }

        else if (direction.equals("left")) {
            // left
            for (int i = column; ((i > 0) && exit == false); i--) {
                if ((board[row][column].getBackground().equals(board[row][i-1].getBackground())) && exit == false) {

                    if (board[row][i-1].getBackground().equals(board[row][i].getBackground()) == false) {
                        exit = true;
                    } else {
                        numberInLine++;
                    }
                }
            }
        }

        else if (direction.equals("right-down")) {
            // right down
            while ((r < this.rows-1) && (c < this.columns-1) && (exit == false)) {
                if ((board[row][column].getBackground().equals(board[r+1][c+1].getBackground())) && exit == false) {

                    if (board[row][column].getBackground().equals(board[r+1][c+1].getBackground()) == true) {
                        numberInLine++;
                    } else {
                        exit = true;
                    }
                }
                r++;
                c++;
            }
        }

        else if (direction.equals("down-left")) {
            // down left
            while ((r < this.rows-1) && (c > 0) && (exit == false)) {
                if ((board[row][column].getBackground().equals(board[r+1][c-1].getBackground())) && exit == false) {

                    if (board[row][column].getBackground().equals(board[r+1][c-1].getBackground()) == true) {
                        numberInLine++;
                    } else {
                        exit = true;
                    }
                }
                r++;
                c--;
            }
        }

        else if (direction.equals("left-up")) {
            // left up
            while ((r > 0) && (c > 0) && (exit == false)) {
                if ((board[row][column].getBackground().equals(board[r-1][c-1].getBackground())) && exit == false) {

                    if (board[row][column].getBackground().equals(board[r-1][c-1].getBackground()) == true) {
                        numberInLine++;
                    } else {
                        exit = true;
                    }
                }
                r--;
                c--;
            }
        }

        return numberInLine;

    }
    
    /**
     * Checks if the board has an open space at position row, column on board.
     * @param board
     * @param row
     * @param column
     * @param direction
     * @return
     */
    public boolean isOpen (Button[][] board, int row, int column, String direction) {
        int r = row;
        int c = column;
        boolean open = false;
        boolean exit = false;
        
        if (direction.equals("up")) {
          // up
          while ((r > 0) && (exit == false)) {
            if ((board[row][column].getBackground().equals(board[r-1][column].getBackground())) == false && exit == false) {
              
              if (board[r-1][column].getBackground().equals(Color.GREEN)) {
                open = true;
                exit = true;
              } else {
                open = false;
                exit = true;
              }
            }
            r--;
          }
        }
        
        else if (direction.equals("right")) {
          // right
          while ((c < this.columns-1) && (exit == false)) {
            if ((board[row][column].getBackground().equals(board[row][c+1].getBackground())) == false && exit == false) {
              if (board[row][c+1].getBackground().equals(Color.GREEN)) {
                open = true;
                exit = true;
              } else {
                open = false;
                exit = true;
              }
            }
            c++;
          }
        }
        
        else if (direction.equals("down")) {
          while ((r < this.rows - 1) && (exit == false)) {
            if ((board[row][column].getBackground().equals(board[r+1][column].getBackground())) == false && exit == false) {
              open = true;
              exit = true;
            } else {
              open = false;
              exit = true;
            }
          }
          r++;
        }
        
        else if (direction.equals("left")) {
          while ((r < this.rows-1) && (exit == false)) {
            if ((board[row][column].getBackground().equals(board[r+1][column].getBackground())) == false && exit == false) {
              if (board[r+1][column].getBackground().equals(Color.GREEN)) {
                open = true;
                exit = true;
              } else {
                open = false;
                exit = true;
              }
            }
            c--;
          }
        }
        
        else if (direction.equals("up-right")) {
          while ((r > 0) && (c < this.columns-1) && (exit == false)) {
            if ((board[row][column].getBackground().equals(board[r-1][c+1].getBackground())) == false && exit == false) {
              if (board[r-1][c+1].getBackground().equals(Color.GREEN)) {
                open = true;
                exit = true;
              } else {
                open = false;
                exit = true;
              }
            }
            r--;
            c++;
          }
        }
        
        else if (direction.equals("right-down")) {
          while ((r < this.rows-1) && (c < this.columns-1) && (exit == false)) {
            if ((board[row][column].getBackground().equals(board[r+1][c+1].getBackground())) == false && exit == false) {
              if (board[r+1][c+1].getBackground().equals(Color.GREEN)) {
                open = true;
                exit = true;
              } else {
                open = false;
                exit = true;
              }
            }
            r++;
            c++;
          }
        }
        
        else if (direction.equals("down-left")) {
          while ((r < this.rows-1) && (c < 0) && (exit == false))
        }
        
    }


}
