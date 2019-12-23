import org.junit.*;
import static org.junit.Assert.*;

import javafx.application.Application;
import javafx.scene.control.Alert;
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
 * JUnit Test for Gomoku class
 * @author Andrea Tongsak
 */ 

public class GomokuTester {
  
  // Will need to create Gomoku with either parameters
  // Top Down
  // Once clicked, need to check the 3-3, 4-4,
  // iEmpty, count4Directions, *numberInLine, declareWinner, *checkWin,

  /** Tester Colors Map */
  private static int GREEN = 0;
  private static int BLACK = 1;
  private static int WHITE = 2;

  /** Tester Directions Map */
  private static int NORTH = 0;
  private static int NORTHEAST = 1;
  private static int EAST = 2;
  private static int SOUTHEAST = 3;
  private static int SOUTH = 4;
  private static int SOUTHWEST = 5;
  private static int WEST = 6;
  private static int NORTHWEST = 7;

  /**
   * Test background coordinates for int[][] board
   * switch white and black color to check
   */
  @Test
  public void setBackgroundTest() {
    Gomoku tester = new Gomoku();
    Gomoku.ProcessClick onClick = tester.new ProcessClick(1,1);
    int[][] board = new int[4][4];
    int[][] expected = new int[4][4];
    expected[1][1] = BLACK;
    onClick.createTestBoard(board);

    assertArrayEquals(expected, board);

    onClick.alternateColor();
    onClick.setXCoor(2);
    expected[2][1] = WHITE;
    onClick.createTestBoard(board);
    assertArrayEquals(expected, board);

  }

  /**
   * Test numberInLine
   * Test 0, 1, many - test all diagonals
   */
  @Test
  public void numberInLineTester() {
    Gomoku tester = new Gomoku();

    // Test 0, 1, many

    int[][] board = new int[6][6];
    board[1][1] = BLACK;
    board[0][1] = BLACK;
    board[2][1] = BLACK;
    assertEquals(1, tester.numberInLineInt(board, 2, 0, 2));// Test 0
    assertEquals(2, tester.numberInLineInt(board, 1, 1, 4));// Test 1
    assertEquals(3, tester.numberInLineInt(board, 2, 1, 0));// Test many (north)
    assertEquals(3, tester.numberInLineInt(board, 0, 1, 4));// Test many (south)

    // Test NORTH
    int[][] north = new int[6][6];
    north[1][1] = BLACK;
    north[0][1] = BLACK;
    north[2][1] = BLACK;
    assertEquals(3, tester.numberInLineInt(north, 2, 1, NORTH));// Test many (north)

    // Test NORTHEAST
    int[][] northeast = new int[6][6];
    northeast[0][2] = BLACK;
    northeast[1][1] = BLACK;
    northeast[2][0] = BLACK;
    assertEquals(3, tester.numberInLineInt(northeast, 2, 0, NORTHEAST));// Test many (northeast)

    // Test EAST
    int[][] east = new int[6][6];
    east[1][0] = BLACK;
    east[1][1] = BLACK;
    east[1][2] = BLACK;
    assertEquals(3, tester.numberInLineInt(east, 1, 0, EAST));// Test many (east)

    // Test SOUTHEAST
    int[][] southeast = new int[6][6];
    southeast[0][0] = BLACK;
    southeast[1][1] = BLACK;
    southeast[2][2] = BLACK;
    assertEquals(3, tester.numberInLineInt(southeast, 0, 0, SOUTHEAST));// Test many (southeast)

    // Test SOUTH
    int[][] south = new int[6][6];
    south[0][1] = BLACK;
    south[1][1] = BLACK;
    south[2][1] = BLACK;
    assertEquals(3, tester.numberInLineInt(south, 0, 1, SOUTH));// Test many (south)

    // Test SOUTHWEST
    int[][] southwest = new int[6][6];
    southwest[0][2] = BLACK;
    southwest[1][1] = BLACK;
    southwest[2][0] = BLACK;
    assertEquals(3, tester.numberInLineInt(southwest, 0, 2, SOUTHWEST));// Test many (southwest)

    // Test WEST
    int[][] west = new int[6][6];
    west[1][0] = BLACK;
    west[1][1] = BLACK;
    west[1][2] = BLACK;
    assertEquals(3, tester.numberInLineInt(west, 1, 2, WEST));// Test many (west)

    // TEST NORTHWEST
    int [][] northwest = new int[6][6];
    northwest[0][0] = BLACK;
    northwest[1][1] = BLACK;
    northwest[2][2] = BLACK;
    assertEquals(3, tester.numberInLineInt(northwest, 2, 2, NORTHWEST));// Test many (west)

  }

  /**
   * Tests count4Directions method
   * Test first, middle, last - can click at the beginning, middle, or end of a consecutive row of numbers.
   *
   */
  @Test
  public void count4DirectionsTester() {
    Gomoku tester = new Gomoku();

    tester.setRows(19);
    tester.setColumns(19);

    int[][] board = new int[19][19];

    board[1][1] = BLACK;
    board[1][2] = BLACK;
    board[1][3] = BLACK;
    board[1][4] = BLACK;
    board[1][5] = BLACK;

    board[2][4] = BLACK;
    board[2][5] = BLACK;
    board[3][6] = BLACK;
    board[4][4] = BLACK;

    tester.setGridInt(board);

    Gomoku.ProcessClick onClick = tester.new ProcessClick(1,3);

    // NORTH, NORTHEAST, EAST, SOUTHEAST (only need to test these directions because they check the other ends too)
    assertEquals(1, onClick.count4DirectionsIntBoard(NORTH));//Test 0
    assertEquals(1, onClick.count4DirectionsIntBoard(NORTHEAST));//Test 1
    assertEquals(5, onClick.count4DirectionsIntBoard(EAST));//Test many
    assertEquals(2, onClick.count4DirectionsIntBoard(SOUTHEAST));//Test many

  }

  /**
   * Tests isOpen method
   * Tests first, middle, last - can click at the beginning, middle, or end of a consecutive row of numbers
   * Test 0, 1, many - tests all diagonals
   */
  @Test
  public void isOpenTester() {
    Gomoku tester = new Gomoku();
    tester.setRows(19);
    tester.setColumns(19);

    int[][] board = new int[19][19];

    board[1][1] = BLACK;
    board[1][2] = BLACK;
    board[1][3] = BLACK;
    board[1][4] = BLACK;

    board[3][4] = BLACK;
    board[3][5] = BLACK;
    board[3][6] = BLACK;
    board[4][4] = BLACK;

    tester.setGridInt(board);

    // up, right, down, left - open
    assertEquals(false, tester.isOpen(board, 0,0, EAST));//Test 0
    assertEquals(true, tester.isOpen(board, 1, 4, NORTH));//Test 1
    assertEquals(true, tester.isOpen(board, 3, 4, SOUTH));//Test many
    assertEquals(true, tester.isOpen(board, 3, 5, EAST));//Test many
    assertEquals(true, tester.isOpen(board, 1, 4, WEST));//Test many

    board[6][1] = BLACK;
    board[7][2] = BLACK;
    board[8][3] = BLACK;
    board[7][4] = BLACK;
    board[9][1] = BLACK;
    board[10][2] = BLACK;
    board[11][3] = BLACK;
    board[12][4] = BLACK;

    tester.setGridInt(board);

    // four diagonals - open
    assertEquals(false, tester.isOpen(board, 0,0, NORTHEAST));//Test 0
    assertEquals(true, tester.isOpen(board, 9, 1, SOUTHWEST));//Test 1
    assertEquals(true, tester.isOpen(board, 8, 3, NORTHWEST));//Test many
    assertEquals(true, tester.isOpen(board, 8, 3, NORTHEAST));//Test many
    assertEquals(true, tester.isOpen(board, 9, 1, SOUTHEAST));//Test many

    board[17][0] = BLACK;
    board[17][1] = BLACK;
    board[17][2] = BLACK;
    board[18][2] = BLACK;
    board[0][18] = BLACK;
    board[1][18] = BLACK;
    board[2][18] = BLACK;
    board[3][18] = BLACK;

    tester.setGridInt(board);

    // up, right, down, left - not open
    assertEquals(false, tester.isOpen(board, 0, 0, NORTH));//Test 0
    assertEquals(false, tester.isOpen(board, 3, 18, NORTH));//Test 1
    assertEquals(false, tester.isOpen(board, 17, 2, SOUTH));//Test many
    assertEquals(false, tester.isOpen(board, 4, 18, EAST));//Test many
    assertEquals(false, tester.isOpen(board, 17, 2, WEST));//Test many


    board[17][0] = WHITE;
    board[17][1] = BLACK;
    board[17][2] = BLACK;
    board[17][3] = BLACK;
    board[17][4] = WHITE;
    board[18][2] = BLACK;
//    board[16][2] = BLACK;
//    board[15][2] = WHITE;
    board[0][18] = WHITE;
    board[1][18] = BLACK;
    board[2][18] = BLACK;
    board[3][18] = BLACK;
    board[4][18] = WHITE;
    tester.setGridInt(board);

    // up, right, down, left - not open due to opposing colors
    assertEquals(false, tester.isOpen(board, 0, 0, NORTH));//Test 0
    assertEquals(false, tester.isOpen(board, 4, 18, NORTH));//Test 1
    assertEquals(false, tester.isOpen(board, 17, 2, SOUTH));//Test many
    assertEquals(false, tester.isOpen(board, 2, 18, EAST));//Test many
    assertEquals(false, tester.isOpen(board, 17, 2, WEST));//Test many

    board[16][16] = BLACK;
    board[17][17] = BLACK;
    board[18][18] = BLACK;
    board[16][14] = BLACK;
    board[17][13] = BLACK;
    board[18][12] = BLACK;
    board[13][0] = BLACK;
    board[14][1] = BLACK;
    board[15][2] = BLACK;
    board[11][16] = BLACK;
    board[10][17] = BLACK;
    board[9][18] = BLACK;

    tester.setGridInt(board);

    // four diagonals - not open
    assertEquals(false, tester.isOpen(board, 0, 0, NORTHEAST));//Test 0
    assertEquals(false, tester.isOpen(board, 11, 16, NORTHEAST));//Test 1
    assertEquals(false, tester.isOpen(board, 16, 16, SOUTHEAST));//Test many
    assertEquals(false, tester.isOpen(board, 16, 14, SOUTHWEST));//Test many
    assertEquals(false, tester.isOpen(board, 15, 2, NORTHWEST));//Test many


  }

  /**
   * Testing getters and setters
   * getRows, setRows, getColumns, setColumns, getWin, setWin, getWinNumber, setWinNumber, getPlayerColor, setPlayerColor,
   * getButtonColor, setButtonColor, getXCoor, getYCoor
   */
  @Test
  public void getAndSetRowTester() {
    Gomoku tester = new Gomoku();
    Gomoku.ProcessClick onClick = tester.new ProcessClick(1,1);
    
    // getRows, setRows
    // Test 0, 1, many
    // Test first, middle, end
    tester.setRows(0);
    assertEquals(0, tester.getRows());
    
    tester.setRows(1);
    assertEquals(1, tester.getRows());
    
    tester.setRows(19);
    assertEquals(19, tester.getRows());
    
    // getColumns, setColumns
    // Test 0, 1, many 
    tester.setColumns(0);
    assertEquals(0, tester.getColumns());
    
    tester.setColumns(1);
    assertEquals(1, tester.getColumns());
    
    tester.setColumns(19);
    assertEquals(19, tester.getColumns());

    // getWinNumber, setWinNumber
    // Test 0, 1, many 
    tester.setWinNumber(0);
    assertEquals(0, tester.getWinNumber());
    
    tester.setWinNumber(1);
    assertEquals(1, tester.getWinNumber());
    
    tester.setWinNumber(19);
    assertEquals(19, tester.getWinNumber());
    
    // getPlayerColor, setPlayerColor
    tester.setPlayerColor(Color.PINK);
    assertEquals(Color.PINK, tester.getPlayerColor());

    // getPlayerColorInt, setPlayerColorInt
    tester.setPlayerColorInt(GREEN);
    assertEquals(GREEN, tester.getPlayerColorInt());

    // getButtonIntColor
    int[][] board = new int[6][6];
    board[1][1] = BLACK;
    board[0][1] = BLACK;
    board[2][1] = BLACK;
    int expectedButtonIntColor = tester.getButtonIntColor(board, 1, 1);
    assertEquals(BLACK, expectedButtonIntColor);
    
    // setXCoor, getXCoor
    onClick.setXCoor(2);
    assertEquals(2, onClick.getXCoor());
    
    // setYCoor, getYCoor
    onClick.setYCoor(2);
    assertEquals(2, onClick.getYCoor());
    

  }

  /**
   * Test alternateColor method
   */
  @Test
  public void alternateColorTester() {
    Gomoku tester = new Gomoku();
    assertEquals(BLACK, tester.getPlayerColorInt());
    Gomoku.ProcessClick onClick = tester.new ProcessClick(1,1);

    onClick.alternateColor();
    assertEquals(WHITE, tester.getPlayerColorInt());

    Gomoku.ProcessClick onClick2 = tester.new ProcessClick(1,2);
    onClick2.alternateColor();
    assertEquals(BLACK, tester.getPlayerColorInt());
  }

  /**
   * Test createTestBoard and resetTestBoard
   */
  @Test
  public void createTestBoardTester() {
    Gomoku tester = new Gomoku();
    Gomoku.ProcessClick onClick = tester.new ProcessClick(1,1);
    int[][] board = new int[6][6];

    onClick.createTestBoard(board);

    assertEquals(BLACK, onClick.getTestBoard());

    onClick.resetTestBoard(board);
    assertEquals(GREEN, onClick.getTestBoard());
  }

  /**
   * Tests the getGridInt and setGridInt method
   */
  @Test
  public void getGridIntTester() {
    Gomoku tester = new Gomoku();
    tester.setGridInt(new int[4][4]);
    int[][] expected = new int[4][4];
    assertArrayEquals(expected, tester.getGridInt());
  }

  /**
   * Tests the displacement: coordinate matches
   * getXDisplacement, getYDisplacement
   */ 
  @Test 
  public void displacementTester() {
    Gomoku tester = new Gomoku();
    
    // Test whether the return displacements are correct (runs through enum for pointer)
    assertEquals(-1, tester.getXDisplacement(0));
    assertEquals(0, tester.getYDisplacement(0));

    assertEquals(-1, tester.getXDisplacement(1));
    assertEquals(1, tester.getYDisplacement(1));

    assertEquals(0, tester.getXDisplacement(2));
    assertEquals(1, tester.getYDisplacement(2));
    
    assertEquals(1, tester.getXDisplacement(3));
    assertEquals(1, tester.getYDisplacement(3));
    
    assertEquals(1, tester.getXDisplacement(4));
    assertEquals(0, tester.getYDisplacement(4));
    
    assertEquals(1, tester.getXDisplacement(5));
    assertEquals(-1, tester.getYDisplacement(5));
    
    assertEquals(0, tester.getXDisplacement(6));
    assertEquals(-1, tester.getYDisplacement(6));
    
    assertEquals(-1, tester.getXDisplacement(7));
    assertEquals(-1, tester.getYDisplacement(7));
  }
  
  /**
   * Testing two helper methods
   */ 
  
  /**
   * Tests threeThree method. 
   * Tests all cases of 3-3
   * Test 0, test 1, test many
   * Test first, middle, end (3-3 can be at beginning of a 3, middle, or end)
   */ 
  @Test
  public void threeThree() {
    Gomoku tester = new Gomoku();
    tester.setRows(19);
    tester.setColumns(19);
    tester.setWinNumber(5);

    int[][] board = new int[19][19];

    board[1][1] = BLACK;
    board[1][2] = BLACK;
    board[1][3] = BLACK;
    board[2][1] = BLACK;
    board[3][1] = BLACK;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick = tester.new ProcessClick(1,1);
    assertEquals(true, onClick.threeThree());

    board[2][5] = BLACK;
    board[2][6] = BLACK;
    board[1][7] = BLACK;
    board[3][7] = BLACK;
    board[2][7] = BLACK;

    tester.setGridInt(board);
    Gomoku.ProcessClick onClick1 = tester.new ProcessClick(2,7);
    assertEquals(true, onClick1.threeThree());

    board[3][9] = BLACK;
    board[3][11] = BLACK;
    board[1][10] = BLACK;
    board[2][10] = BLACK;
    board[3][10] = BLACK;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick2 = tester.new ProcessClick(3,10);
    assertEquals(true, onClick2.threeThree());

    board[1][13] = BLACK;
    board[3][13] = BLACK;
    board[2][14] = BLACK;
    board[2][15] = BLACK;
    board[2][13] = BLACK;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick3 = tester.new ProcessClick(2,13);
    assertEquals(true, onClick3.threeThree());

    board[5][2] = BLACK;
    board[5][3] = BLACK;
    board[6][1] = BLACK;
    board[7][1] = BLACK;
    board[5][1] = BLACK;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick4 = tester.new ProcessClick(5,1);
    assertEquals(true, onClick4.threeThree());

    board[5][13] = BLACK;
    board[6][13] = BLACK;
    board[7][14] = BLACK;
    board[7][15] = BLACK;
    board[7][13] = BLACK;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick5 = tester.new ProcessClick(7,13);
    assertEquals(true, onClick5.threeThree());

    board[9][2] = BLACK;
    board[10][1] = BLACK;
    board[10][3] = BLACK;
    board[11][2] = BLACK;
    board[10][2] = BLACK;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick6 = tester.new ProcessClick(10,2);
    assertEquals(true, onClick6.threeThree());

    board[1][1] = BLACK;
    board[3][1] = BLACK;
    board[1][3] = BLACK;
    board[3][3] = BLACK;
    board[2][2] = BLACK;
    board[4][4] = WHITE;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick7 = tester.new ProcessClick(2,2);
    assertEquals(false, onClick7.threeThree());

  }

  /**
   * Tests fourFour method. Tests all cases of 4-4.
   * Test 0, test 1, test many - tests all cases of 4-4.
   * Test first, test middle, test last - 4-4 can be at beginning of a 4, middle or end.
   */
  @Test
  public void fourFour() {
    Gomoku tester = new Gomoku();
    tester.setRows(19);
    tester.setColumns(19);
    tester.setWinNumber(5);

    int[][] board = new int[19][19];

    board[0][1] = BLACK;
    board[1][1] = BLACK;
    board[2][1] = BLACK;

    board[3][2] = BLACK;
    board[3][3] = BLACK;
    board[3][4] = BLACK;

    tester.setGridInt(board);

    Gomoku.ProcessClick onClick = tester.new ProcessClick(3,1);
    onClick.createTestBoard(tester.getGridInt());

    assertEquals(4, onClick.count4DirectionsIntBoard(NORTH));//Test 0
    assertEquals(1, onClick.count4DirectionsIntBoard(NORTHEAST));//Test 1
    assertEquals(1, onClick.count4DirectionsIntBoard(SOUTHEAST));//Test many
    assertEquals(4, onClick.count4DirectionsIntBoard(EAST));//Test many

    assertEquals(true, onClick.fourFour());

    board[1][6] = BLACK;
    board[2][6] = BLACK;
    board[3][6] = BLACK;
    board[4][6] = BLACK;

    board[2][7] = BLACK;
    board[2][8] = BLACK;
    board[2][9] = BLACK;

    tester.setGridInt(board);
    Gomoku.ProcessClick onClick1 = tester.new ProcessClick(2,6);
    assertEquals(true, onClick1.fourFour());

    board[1][11] = BLACK;
    board[2][11] = BLACK;
    board[3][11] = BLACK;
    board[4][11] = BLACK;
    board[4][12] = BLACK;
    board[4][13] = BLACK;
    board[4][14] = BLACK;

    Gomoku.ProcessClick onClick2 = tester.new ProcessClick(4,11);
    assertEquals(true, onClick2.fourFour());

    board[8][1] = BLACK;
    board[8][2] = BLACK;
    board[8][3] = BLACK;
    board[8][4] = BLACK;
    board[6][4] = BLACK;
    board[7][4] = BLACK;
    board[9][4] = BLACK;

    tester.setGridInt(board);

    Gomoku.ProcessClick onClick3 = tester.new ProcessClick(8,4);
    assertEquals(true, onClick3.fourFour());

    board[14][1] = BLACK;
    board[14][2] = BLACK;
    board[14][3] = BLACK;
    board[14][4] = BLACK;
    board[11][2] = BLACK;
    board[12][2] = BLACK;
    board[13][2] = BLACK;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick4 = tester.new ProcessClick(14,2);
    assertEquals(true, onClick4.fourFour());

    board[1][1] = BLACK;
    board[2][2] = BLACK;
    board[3][3] = BLACK;
    board[4][4] = BLACK;
    board[5][3] = BLACK;
    board[6][2] = BLACK;
    board[7][1] = BLACK;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick5 = tester.new ProcessClick(4,4);
    assertEquals(true, onClick5.fourFour());

    board[1][9] = BLACK;
    board[2][8] = BLACK;
    board[3][7] = BLACK;
    board[4][6] = BLACK;
    board[5][7] = BLACK;
    board[6][8] = BLACK;
    board[7][9] = BLACK;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick6 = tester.new ProcessClick(4,6);
    assertEquals(true, onClick6.fourFour());

    board[2][1] = BLACK;
    board[2][3] = BLACK;
    board[3][2] = BLACK;
    board[4][1] = BLACK;
    board[4][3] = BLACK;
    board[5][4] = BLACK;
    board[1][4] = BLACK;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick7 = tester.new ProcessClick(3,2);
    assertEquals(true, onClick7.fourFour());

    board[1][7] = BLACK;
    board[2][8] = BLACK;
    board[3][9] = BLACK;
    board[4][10] = BLACK;
    board[4][6] = BLACK;
    board[3][7] = BLACK;
    board[1][9] = BLACK;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick8 = tester.new ProcessClick(2,8);
    assertEquals(true, onClick8.fourFour());

    board[1][7] = WHITE;
    board[2][8] = BLACK;
    board[3][9] = BLACK;
    board[4][10] = BLACK;
    board[4][6] = BLACK;
    board[3][7] = BLACK;
    board[1][9] = WHITE;
    tester.setGridInt(board);
    Gomoku.ProcessClick onClick9 = tester.new ProcessClick(2,8);
    assertEquals(false, onClick9.fourFour());

  }
}
