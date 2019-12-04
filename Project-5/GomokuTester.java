import org.junit.*;
import static org.junit.Assert.*;

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

/**
 * JUnit Test for Gomoku class
 * @author Andrea Tongsak
 */ 

public class GomokuTester {
//  Gomoku game = new Gomoku();
  
  /**
   * Testing two helper methods
   */ 
  
  /**
   * Tests threeThree method. 
   * Tests all cases of 3-3
   * Test 0, test 1, test many
   * Test first, middle, end (3-3 can be at beginning of a 3, middle, or end)
   */ 
//  @Test
//  public void threeThree() {
//    game.setColor(1, 1, Color.BLACK);
//    game.setColor(1, 3, Color.BLACK);
//    game.setColor(2, 2, Color.BLACK);
//    game.setColor(3, 2, Color.BLACK);
//    game.setColor(1, 2, Color.BLACK);
//    assertEquals(true, game.threeThree(1, 2));
//    assertEquals(false, game.threeThree(1,1));//tests 0.
//    
//    game.setColor(2, 5, Color.BLACK);
//    game.setColor(2, 6, Color.BLACK);
//    game.setColor(1, 7, Color.BLACK);
//    game.setColor(3, 7, Color.BLACK);
//    game.setColor(2, 7, Color.BLACK);
//    assertEquals(true, game.threeThree(2, 7));
//    
//    game.setColor(3, 9, Color.BLACK);
//    game.setColor(3, 11, Color.BLACK);
//    game.setColor(1, 10, Color.BLACK);
//    game.setColor(2, 10, Color.BLACK);
//    game.setColor(3, 10, Color.BLACK);
//    assertEquals(true, game.threeThree(3, 10));
//    
//    game.setColor(1, 13, Color.BLACK);
//    game.setColor(3, 13, Color.BLACK);
//    game.setColor(2, 14, Color.BLACK);
//    game.setColor(2, 15, Color.BLACK);
//    game.setColor(2, 13, Color.BLACK);
//    assertEquals(true, game.threeThree(2, 13));
//    
//    game.setColor(5, 2, Color.BLACK);
//    game.setColor(5, 3, Color.BLACK);
//    game.setColor(6, 1, Color.BLACK);
//    game.setColor(7, 1, Color.BLACK);
//    game.setColor(5, 1, Color.BLACK);
//    assertEquals(true, game.threeThree(5, 1));
//    
//    game.setColor(5, 5, Color.BLACK);
//    game.setColor(5, 6, Color.BLACK);
//    game.setColor(6, 7, Color.BLACK);
//    game.setColor(7, 7, Color.BLACK);
//    game.setColor(5, 7, Color.BLACK);
//    assertEquals(true, game.threeThree(5, 7));
//    
//    game.setColor(7, 9, Color.BLACK);
//    game.setColor(7, 10, Color.BLACK);
//    game.setColor(5, 11, Color.BLACK);
//    game.setColor(6, 11, Color.BLACK);
//    game.setColor(7, 11, Color.BLACK);
//    assertEquals(true, game.threeThree(7, 11));
//    
//    game.setColor(5, 13, Color.BLACK);
//    game.setColor(6, 13, Color.BLACK);
//    game.setColor(7, 14, Color.BLACK);
//    game.setColor(7, 15, Color.BLACK);
//    game.setColor(7, 13, Color.BLACK);
//    assertEquals(true, game.threeThree(7, 13));
//    
//    game.setColor(9, 2, Color.BLACK);
//    game.setColor(10, 1, Color.BLACK);
//    game.setColor(10, 3, Color.BLACK);
//    game.setColor(11, 2, Color.BLACK);
//    game.setColor(10, 2, Color.BLACK);
//    assertEquals(true, game.threeThree(10, 2));
//    
//    Gomoku test1 = new Gomoku(5,5);
//    test1.setColor(1, 1, Color.BLACK);
//    test1.setColor(3, 1, Color.BLACK);
//    test1.setColor(1, 3, Color.BLACK);
//    test1.setColor(3, 3, Color.BLACK);
//    test1.setColor(2, 2, Color.BLACK);
//    assertEquals(true, test1.threeThree(2, 2));
//    
//    Gomoku test2 = new Gomoku (7,7);
//    test2.setColor(1, 3, Color.BLACK);
//    test2.setColor(2, 4, Color.BLACK);
//    test2.setColor(3, 5, Color.BLACK);
//    test2.setColor(3, 3, Color.BLACK);
//    test2.setColor(4, 2, Color.BLACK);
//    assertEquals(true, test2.threeThree(2, 4));
//    
//    Gomoku test3 = new Gomoku (7,7);
//    test3.setColor(2, 1, Color.BLACK);
//    test3.setColor(3, 2, Color.BLACK);
//    test3.setColor(4, 3, Color.BLACK);
//    test3.setColor(2, 3, Color.BLACK);
//    test3.setColor(1, 4, Color.BLACK);
//    assertEquals(true, test3.threeThree(3, 2));
//    
//    Gomoku test4 = new Gomoku(7, 7);
//    test4.setColor(4, 1, Color.BLACK);
//    test4.setColor(3, 2, Color.BLACK);
//    test4.setColor(2, 3, Color.BLACK);
//    test4.setColor(4, 5, Color.BLACK);
//    test4.setColor(3, 4, Color.BLACK);
//    assertEquals(true, test4.threeThree(2, 3));
//    
//    Gomoku test5 = new Gomoku(7,7);
//    test5.setColor(1, 1, Color.BLACK);
//    test5.setColor(2, 2, Color.BLACK);
//    test5.setColor(3, 3, Color.BLACK);
//    test5.setColor(4, 2, Color.BLACK);
//    test5.setColor(5, 1, Color.BLACK);
//    assertEquals(true, test5.threeThree(3, 3));
//    
//    Gomoku test6 = new Gomoku(7,7);
//    test6.setColor(1, 1, Color.BLACK);
//    test6.setColor(2, 2, Color.BLACK);
//    test6.setColor(3, 3, Color.BLACK);
//    test6.setColor(2, 4, Color.BLACK);
//    test6.setColor(1, 5, Color.BLACK);
//    assertEquals(true, test6.threeThree(3, 3));
//    
//    Gomoku test7 = new Gomoku(7,7);
//    test7.setColor(3, 1, Color.BLACK);
//    test7.setColor(2, 2, Color.BLACK);
//    test7.setColor(1, 3, Color.BLACK);
//    test7.setColor(4, 2, Color.BLACK);
//    test7.setColor(5, 3, Color.BLACK);
//    assertEquals(true, test7.threeThree(3, 1));
//    
//    Gomoku test8 = new Gomoku(7,7);
//    test8.setColor(3, 1, Color.BLACK);
//    test8.setColor(2, 2, Color.BLACK);
//    test8.setColor(1, 3, Color.BLACK);
//    test8.setColor(3, 3, Color.BLACK);
//    test8.setColor(4, 4, Color.BLACK);
//    assertEquals(true, test8.threeThree(2, 2));
//    
//    Gomoku test9 = new Gomoku(7,7);
//    test9.setColor(1, 1, Color.BLACK);
//    test9.setColor(2, 2, Color.BLACK);
//    test9.setColor(3, 3, Color.BLACK);
//    test9.setColor(4, 2, Color.BLACK);
//    test9.setColor(2, 4, Color.BLACK);
//    assertEquals(true, test9.threeThree(3, 3));
//    
//    Gomoku test10 = new Gomoku();
//    test10.setColor(3, 1, Color.BLACK);
//    test10.setColor(3, 2, Color.BLACK);
//    test10.setColor(3, 3, Color.BLACK);
//    test10.setColor(2, 2, Color.BLACK);
//    test10.setColor(1, 3, Color.BLACK);
//    assertEquals(true, test10.threeThree(3, 1));
//    
//    test10.setColor(3, 5, Color.BLACK);
//    test10.setColor(3, 6, Color.BLACK);
//    test10.setColor(3, 7, Color.BLACK);
//    test10.setColor(2, 7, Color.BLACK);
//    test10.setColor(1, 8, Color.BLACK);
//    assertEquals(true, test10.threeThree(3, 1));
//    
//    test10.setColor(3, 9, Color.BLACK);
//    test10.setColor(3, 10, Color.BLACK);
//    test10.setColor(3, 11, Color.BLACK);
//    test10.setColor(2, 12, Color.BLACK);
//    test10.setColor(1, 13, Color.BLACK);
//    assertEquals(true, test10.threeThree(3, 1));
//    
//    test10.setColor(3, 15, Color.BLACK);
//    test10.setColor(2, 15, Color.BLACK);
//    test10.setColor(2, 16, Color.BLACK);
//    test10.setColor(2, 17, Color.BLACK);
//    test10.setColor(1, 17, Color.BLACK);
//    assertEquals(true, test10.threeThree(2, 16));
//    
//    Gomoku test11 = new Gomoku();
//    test11.setColor(1, 1, Color.BLACK);
//    test11.setColor(1, 2, Color.BLACK);
//    test11.setColor(1, 3, Color.BLACK);
//    test11.setColor(2, 2, Color.BLACK);
//    test11.setColor(3, 1, Color.BLACK);
//    assertEquals(true, test11.threeThree(1, 3));
//
//    test11.setColor(1, 6, Color.BLACK);
//    test11.setColor(1, 7, Color.BLACK);
//    test11.setColor(1, 8, Color.BLACK);
//    test11.setColor(2, 6, Color.BLACK);
//    test11.setColor(3, 5, Color.BLACK);
//    assertEquals(true, test11.threeThree(1, 7));
//    
//    test11.setColor(1, 12, Color.BLACK);
//    test11.setColor(1, 13, Color.BLACK);
//    test11.setColor(1, 14, Color.BLACK);
//    test11.setColor(2, 11, Color.BLACK);
//    test11.setColor(3, 10, Color.BLACK);
//    assertEquals(true, test11.threeThree(1, 12));
//    
//    Gomoku test12 = new Gomoku();
//    test12.setColor(1, 1, Color.BLACK);
//    test12.setColor(1, 2, Color.BLACK);
//    test12.setColor(1, 3, Color.BLACK);
//    test12.setColor(2, 2, Color.BLACK);
//    test12.setColor(3, 3, Color.BLACK);
//    assertEquals(true, test12.threeThree(1, 1));
//
//    test12.setColor(1, 6, Color.BLACK);
//    test12.setColor(1, 7, Color.BLACK);
//    test12.setColor(1, 8, Color.BLACK);
//    test12.setColor(2, 8, Color.BLACK);
//    test12.setColor(3, 9, Color.BLACK);
//    assertEquals(true, test12.threeThree(1, 7));
//    
//    test12.setColor(1, 12, Color.BLACK);
//    test12.setColor(1, 13, Color.BLACK);
//    test12.setColor(1, 14, Color.BLACK);
//    test12.setColor(2, 15, Color.BLACK);
//    test12.setColor(3, 16, Color.BLACK);
//    assertEquals(true, test12.threeThree(1, 14));
//    
//    Gomoku test13 = new Gomoku();
//    test13.setColor(1, 1, Color.BLACK);
//    test13.setColor(2, 2, Color.BLACK);
//    test13.setColor(3, 3, Color.BLACK);
//    test13.setColor(3, 2, Color.BLACK);
//    test13.setColor(3, 4, Color.BLACK);
//    assertEquals(true, test13.threeThree(3, 3));
//
//    test13.setColor(1, 6, Color.BLACK);
//    test13.setColor(2, 7, Color.BLACK);
//    test13.setColor(3, 8, Color.BLACK);
//    test13.setColor(3, 9, Color.BLACK);
//    test13.setColor(3, 10, Color.BLACK);
//    assertEquals(true, test13.threeThree(3, 8));
//    
//    test13.setColor(3, 12, Color.BLACK);
//    test13.setColor(3, 13, Color.BLACK);
//    test13.setColor(3, 14, Color.BLACK);
//    test13.setColor(2, 13, Color.BLACK);
//    test13.setColor(1, 12, Color.BLACK);
//    assertEquals(true, test13.threeThree(3, 14));
//    
//    test13.setColor(5, 1, Color.BLACK);
//    test13.setColor(6, 1, Color.BLACK);
//    test13.setColor(6, 2, Color.BLACK);
//    test13.setColor(6, 3, Color.BLACK);
//    test13.setColor(7, 3, Color.BLACK);
//    assertEquals(true, test13.threeThree(6, 2));
//    
//    Gomoku test14 = new Gomoku();
//    test14.setColor(1, 1, Color.BLACK);
//    test14.setColor(2, 2, Color.BLACK);
//    test14.setColor(3, 3, Color.BLACK);
//    test14.setColor(2, 3, Color.BLACK);
//    test14.setColor(2, 4, Color.BLACK);
//    assertEquals(true, test14.threeThree(2, 2));
//
//    test14.setColor(5, 2, Color.BLACK);
//    test14.setColor(6, 1, Color.BLACK);
//    test14.setColor(6, 2, Color.BLACK);
//    test14.setColor(6, 3, Color.BLACK);
//    test14.setColor(7, 4, Color.BLACK);
//    assertEquals(true, test14.threeThree(6, 3));
//    
//    test14.setColor(2, 6, Color.BLACK);
//    test14.setColor(2, 7, Color.BLACK);
//    test14.setColor(2, 8, Color.BLACK);
//    test14.setColor(1, 9, Color.BLACK);
//    test14.setColor(3, 7, Color.BLACK);
//    assertEquals(true, test14.threeThree(2, 8));
//    
//    test14.setColor(3, 11, Color.BLACK);
//    test14.setColor(2, 12, Color.BLACK);
//    test14.setColor(1, 13, Color.BLACK);
//    test14.setColor(2, 13, Color.BLACK);
//    test14.setColor(2, 14, Color.BLACK);
//    assertEquals(true, test14.threeThree(2, 12));
//  }
//  
//  /**
//   * Tests fourFour method. Tests all cases of 4-4.
//   * Test 0, test 1, test many - tests all cases of 4-4.
//   * Test first, test middle, test last - 4-4 can be at beginning of a 4, middle or end.
//   */
//  @Test
//  public void fourFour() {
//    Gomoku test = new Gomoku();
//    
//    test.setColor(1, 1, Color.BLACK);
//    test.setColor(2, 1, Color.BLACK);
//    test.setColor(3, 1, Color.BLACK);
//    test.setColor(4, 1, Color.BLACK);
//    test.setColor(3, 2, Color.BLACK);
//    test.setColor(3, 3, Color.BLACK);
//    test.setColor(3, 4, Color.BLACK);
//    assertEquals(true, test.fourFour(3, 1));   
//    
//    test.setColor(1, 6, Color.BLACK);
//    test.setColor(2, 6, Color.BLACK);
//    test.setColor(3, 6, Color.BLACK);
//    test.setColor(4, 6, Color.BLACK);
//    test.setColor(2, 7, Color.BLACK);
//    test.setColor(2, 8, Color.BLACK);
//    test.setColor(2, 9, Color.BLACK);
//    assertEquals(true, test.fourFour(2, 6));   
//    
//    test.setColor(1, 11, Color.BLACK);
//    test.setColor(2, 11, Color.BLACK);
//    test.setColor(3, 11, Color.BLACK);
//    test.setColor(4, 11, Color.BLACK);
//    test.setColor(4, 12, Color.BLACK);
//    test.setColor(4, 13, Color.BLACK);
//    test.setColor(4, 14, Color.BLACK);
//    assertEquals(true, test.fourFour(4, 11));   
//    
//    test.setColor(8, 1, Color.BLACK);
//    test.setColor(8, 2, Color.BLACK);
//    test.setColor(8, 3, Color.BLACK);
//    test.setColor(8, 4, Color.BLACK);
//    test.setColor(6, 4, Color.BLACK);
//    test.setColor(7, 4, Color.BLACK);
//    test.setColor(9, 4, Color.BLACK);
//    assertEquals(true, test.fourFour(8, 4));   
//    
//    test.setColor(7, 6, Color.BLACK);
//    test.setColor(7, 7, Color.BLACK);
//    test.setColor(7, 8, Color.BLACK);
//    test.setColor(7, 9, Color.BLACK);
//    test.setColor(6, 9, Color.BLACK);
//    test.setColor(9, 9, Color.BLACK);
//    test.setColor(8, 9, Color.BLACK);
//    assertEquals(true, test.fourFour(7, 9));   
//    
//    test.setColor(8, 11, Color.BLACK);
//    test.setColor(8, 12, Color.BLACK);
//    test.setColor(8, 13, Color.BLACK);
//    test.setColor(8, 14, Color.BLACK);
//    test.setColor(9, 13, Color.BLACK);
//    test.setColor(6, 13, Color.BLACK);
//    test.setColor(7, 13, Color.BLACK);
//    assertEquals(true, test.fourFour(8, 13));   
//    
//    test.setColor(14, 1, Color.BLACK);
//    test.setColor(14, 2, Color.BLACK);
//    test.setColor(14, 3, Color.BLACK);
//    test.setColor(14, 4, Color.BLACK);
//    test.setColor(11, 2, Color.BLACK);
//    test.setColor(12, 2, Color.BLACK);
//    test.setColor(13, 2, Color.BLACK);
//    assertEquals(true, test.fourFour(14, 2));     
//    
//    test.setColor(14, 6, Color.BLACK);
//    test.setColor(14, 7, Color.BLACK);
//    test.setColor(14, 8, Color.BLACK);
//    test.setColor(14, 9, Color.BLACK);
//    test.setColor(11, 8, Color.BLACK);
//    test.setColor(12, 8, Color.BLACK);
//    test.setColor(13, 8, Color.BLACK);
//    assertEquals(true, test.fourFour(14, 8));    
//    
//    test.setColor(12, 11, Color.BLACK);
//    test.setColor(12, 12, Color.BLACK);
//    test.setColor(12, 13, Color.BLACK);
//    test.setColor(12, 14, Color.BLACK);
//    test.setColor(11, 13, Color.BLACK);
//    test.setColor(13, 13, Color.BLACK);
//    test.setColor(14, 13, Color.BLACK);
//    assertEquals(true, test.fourFour(12, 13));     
//    
//    Gomoku test1 = new Gomoku();
//    test1.setColor(1, 2, Color.BLACK);
//    test1.setColor(2, 2, Color.BLACK);
//    test1.setColor(2, 1, Color.BLACK);
//    test1.setColor(3, 2, Color.BLACK);
//    test1.setColor(4, 2, Color.BLACK);
//    test1.setColor(2, 3, Color.BLACK);
//    test1.setColor(2, 4, Color.BLACK);
//    assertEquals(true, test1.fourFour(2, 2));   
//    
//    test1.setColor(6, 2, Color.BLACK);
//    test1.setColor(7, 2, Color.BLACK);
//    test1.setColor(8, 2, Color.BLACK);
//    test1.setColor(9, 2, Color.BLACK);
//    test1.setColor(8, 1, Color.BLACK);
//    test1.setColor(8, 3, Color.BLACK);
//    test1.setColor(8, 4, Color.BLACK);
//    assertEquals(true, test1.fourFour(8, 2)); 
//    
//    test1.setColor(11, 1, Color.BLACK);
//    test1.setColor(12, 1, Color.BLACK);
//    test1.setColor(13, 1, Color.BLACK);
//    test1.setColor(14, 1, Color.BLACK);
//    test1.setColor(11, 2, Color.BLACK);
//    test1.setColor(11, 3, Color.BLACK);
//    test1.setColor(11, 4, Color.BLACK);
//    assertEquals(true, test1.fourFour(11, 1));   
//    
//    test1.setColor(4, 6, Color.BLACK);
//    test1.setColor(4, 7, Color.BLACK);
//    test1.setColor(4, 8, Color.BLACK);
//    test1.setColor(4, 9, Color.BLACK);
//    test1.setColor(3, 9, Color.BLACK);
//    test1.setColor(2, 9, Color.BLACK);
//    test1.setColor(1, 9, Color.BLACK);
//    assertEquals(true, test1.fourFour(4, 9)); 
//    
//    test1.setColor(6, 6, Color.BLACK);
//    test1.setColor(6, 7, Color.BLACK);
//    test1.setColor(6, 8, Color.BLACK);
//    test1.setColor(6, 9, Color.BLACK);
//    test1.setColor(7, 9, Color.BLACK);
//    test1.setColor(8, 9, Color.BLACK);
//    test1.setColor(9, 9, Color.BLACK);
//    assertEquals(true, test1.fourFour(6, 9)); 
//    
//    test1.setColor(11, 6, Color.BLACK);
//    test1.setColor(11, 7, Color.BLACK);
//    test1.setColor(11, 8, Color.BLACK);
//    test1.setColor(11, 9, Color.BLACK);
//    test1.setColor(12, 7, Color.BLACK);
//    test1.setColor(13, 7, Color.BLACK);
//    test1.setColor(14, 7, Color.BLACK);
//    assertEquals(true, test1.fourFour(11, 7)); 
//    
//    test1.setColor(1, 11, Color.BLACK);
//    test1.setColor(1, 12, Color.BLACK);
//    test1.setColor(1, 13, Color.BLACK);
//    test1.setColor(1, 14, Color.BLACK);
//    test1.setColor(2, 13, Color.BLACK);
//    test1.setColor(3, 13, Color.BLACK);
//    test1.setColor(4, 13, Color.BLACK);
//    assertEquals(true, test1.fourFour(1, 13)); 
//    
//    Gomoku test2 = new Gomoku();
//    test2.setColor(1, 1, Color.BLACK);
//    test2.setColor(2, 2, Color.BLACK);
//    test2.setColor(3, 3, Color.BLACK);
//    test2.setColor(4, 4, Color.BLACK);
//    test2.setColor(5, 3, Color.BLACK);
//    test2.setColor(6, 2, Color.BLACK);
//    test2.setColor(7, 1, Color.BLACK);
//    assertEquals(true, test2.fourFour(4, 4)); 
//    
//    test2.setColor(1, 9, Color.BLACK);
//    test2.setColor(2, 8, Color.BLACK);
//    test2.setColor(3, 7, Color.BLACK);
//    test2.setColor(4, 6, Color.BLACK);
//    test2.setColor(5, 7, Color.BLACK);
//    test2.setColor(6, 8, Color.BLACK);
//    test2.setColor(7, 9, Color.BLACK);
//    assertEquals(true, test2.fourFour(4, 6)); 
//    
//    test2.setColor(4, 11, Color.BLACK);
//    test2.setColor(3, 12, Color.BLACK);
//    test2.setColor(2, 13, Color.BLACK);
//    test2.setColor(1, 14, Color.BLACK);
//    test2.setColor(2, 15, Color.BLACK);
//    test2.setColor(3, 16, Color.BLACK);
//    test2.setColor(4, 17, Color.BLACK);
//    assertEquals(true, test2.fourFour(1, 14)); 
//    
//    Gomoku test3 = new Gomoku();
//    test3.setColor(1, 1, Color.BLACK);
//    test3.setColor(2, 2, Color.BLACK);
//    test3.setColor(3, 3, Color.BLACK);
//    test3.setColor(4, 4, Color.BLACK);
//    test3.setColor(3, 5, Color.BLACK);
//    test3.setColor(2, 6, Color.BLACK);
//    test3.setColor(1, 7, Color.BLACK);
//    assertEquals(true, test3.fourFour(4, 4)); 
//    
//    test3.setColor(1, 10, Color.BLACK);
//    test3.setColor(2, 11, Color.BLACK);
//    test3.setColor(3, 12, Color.BLACK);
//    test3.setColor(4, 13, Color.BLACK);
//    test3.setColor(3, 10, Color.BLACK);
//    test3.setColor(4, 9, Color.BLACK);
//    test3.setColor(5, 8, Color.BLACK);
//    assertEquals(true, test3.fourFour(2, 11));
//    
//    Gomoku test4 = new Gomoku();
//    test4.setColor(6, 1, Color.BLACK);
//    test4.setColor(7, 2, Color.BLACK);
//    test4.setColor(8, 3, Color.BLACK);
//    test4.setColor(9, 4, Color.BLACK);
//    test4.setColor(7, 4, Color.BLACK);
//    test4.setColor(9, 2, Color.BLACK);
//    test4.setColor(10, 1, Color.BLACK);
//    assertEquals(true, test4.fourFour(8, 3)); 
//    
//    test4.setColor(1, 7, Color.BLACK);
//    test4.setColor(2, 8, Color.BLACK);
//    test4.setColor(3, 9, Color.BLACK);
//    test4.setColor(4, 10, Color.BLACK);
//    test4.setColor(4, 8, Color.BLACK);
//    test4.setColor(2, 10, Color.BLACK);
//    test4.setColor(1, 11, Color.BLACK);
//    assertEquals(true, test4.fourFour(3, 9)); 
//    
//    test4.setColor(1, 14, Color.BLACK);
//    test4.setColor(2, 15, Color.BLACK);
//    test4.setColor(3, 16, Color.BLACK);
//    test4.setColor(4, 17, Color.BLACK);
//    test4.setColor(5, 14, Color.BLACK);
//    test4.setColor(6, 13, Color.BLACK);
//    test4.setColor(4, 15, Color.BLACK);
//    assertEquals(true, test4.fourFour(3, 16)); 
//    
//    Gomoku test5 = new Gomoku();
//    
//    test5.setColor(2, 1, Color.BLACK);
//    test5.setColor(2, 3, Color.BLACK);
//    test5.setColor(3, 2, Color.BLACK);
//    test5.setColor(4, 1, Color.BLACK);
//    test5.setColor(4, 3, Color.BLACK);
//    test5.setColor(5, 4, Color.BLACK);
//    test5.setColor(1, 4, Color.BLACK);
//    assertEquals(true, test5.fourFour(3, 2)); 
//    
//    test5.setColor(1, 7, Color.BLACK);
//    test5.setColor(2, 8, Color.BLACK);
//    test5.setColor(3, 9, Color.BLACK);
//    test5.setColor(4, 10, Color.BLACK);
//    test5.setColor(4, 6, Color.BLACK);
//    test5.setColor(3, 7, Color.BLACK);
//    test5.setColor(1, 9, Color.BLACK);
//    assertEquals(true, test5.fourFour(2, 8)); 
//    
//    test5.setColor(4, 12, Color.BLACK);
//    test5.setColor(3, 13, Color.BLACK);
//    test5.setColor(2, 14, Color.BLACK);
//    test5.setColor(1, 15, Color.BLACK);
//    test5.setColor(3, 15, Color.BLACK);
//    test5.setColor(4, 16, Color.BLACK);
//    test5.setColor(5, 17, Color.BLACK);
//    assertEquals(true, test5.fourFour(2, 14)); 
//    
//    Gomoku test6 = new Gomoku();
//    test6.setColor(3, 1, Color.BLACK);
//    test6.setColor(4, 2, Color.BLACK);
//    test6.setColor(5, 3, Color.BLACK);
//    test6.setColor(6, 4, Color.BLACK);
//    test6.setColor(3, 3, Color.BLACK);
//    test6.setColor(2, 4, Color.BLACK);
//    test6.setColor(1, 5, Color.BLACK);
//    assertEquals(true, test6.fourFour(4, 2)); 
//    
//    test6.setColor(2, 7, Color.BLACK);
//    test6.setColor(3, 8, Color.BLACK);
//    test6.setColor(4, 9, Color.BLACK);
//    test6.setColor(5, 10, Color.BLACK);
//    test6.setColor(3, 10, Color.BLACK);
//    test6.setColor(2, 11, Color.BLACK);
//    test6.setColor(1, 12, Color.BLACK);
//    assertEquals(true, test6.fourFour(4, 9)); 
//    
//    test6.setColor(1, 14, Color.BLACK);
//    test6.setColor(2, 15, Color.BLACK);
//    test6.setColor(3, 16, Color.BLACK);
//    test6.setColor(4, 17, Color.BLACK);
//    test6.setColor(3, 18, Color.BLACK);
//    test6.setColor(5, 16, Color.BLACK);
//    test6.setColor(6, 15, Color.BLACK);
//    assertEquals(true, test6.fourFour(4, 17)); 
//    
//    Gomoku test7 = new Gomoku();
//          
//    test7.setColor(1, 1, Color.BLACK);
//    test7.setColor(2, 2, Color.BLACK);
//    test7.setColor(3, 3, Color.BLACK);
//    test7.setColor(4, 4, Color.BLACK);
//    test7.setColor(2, 6, Color.BLACK);
//    test7.setColor(3, 5, Color.BLACK);
//    test7.setColor(5, 3, Color.BLACK);
//    assertEquals(true, test7.fourFour(4, 4)); 
//    
//    test7.setColor(4, 8, Color.BLACK);
//    test7.setColor(3, 9, Color.BLACK);
//    test7.setColor(2, 10, Color.BLACK);
//    test7.setColor(1, 11, Color.BLACK);
//    test7.setColor(4, 10, Color.BLACK);
//    test7.setColor(5, 11, Color.BLACK);
//    test7.setColor(6, 12, Color.BLACK);
//    assertEquals(true, test7.fourFour(3, 9));
//  }
//  
//  /**
//   * Tests the isWon method.
//   * Test first, test middle test last means testing the first(1st), middle(2-4) or last piece(5th) of a win.
//   * Test 0, Test 1, Test many means testing in all 8 directions, and testing non winning places. 
//   */
//  @Test
//  public void isWon() {
//    game.setColor(1, 1, Color.BLACK);
//    game.setColor(1, 2, Color.BLACK);
//    game.setColor(1, 3, Color.BLACK);
//    game.setColor(1, 4, Color.BLACK);
//    game.setColor(1, 5, Color.BLACK);
//    
//    game.setColor(3, 1, Color.BLACK);
//    game.setColor(4, 1, Color.BLACK);
//    game.setColor(5, 1, Color.BLACK);
//    game.setColor(6, 1, Color.BLACK);
//    game.setColor(7, 1, Color.BLACK);
//    
//    game.setColor(1, 7, Color.BLACK);
//    game.setColor(2, 8, Color.BLACK);
//    game.setColor(3, 9, Color.BLACK);
//    game.setColor(4, 10, Color.BLACK);
//    game.setColor(5, 11, Color.BLACK);
//    
//    game.setColor(14, 1, Color.BLACK);
//    game.setColor(13, 2, Color.BLACK);
//    game.setColor(12, 3, Color.BLACK);
//    game.setColor(11, 4, Color.BLACK);
//    game.setColor(10, 5, Color.BLACK);
//    
//    assertEquals(false, game.isWon(0,0));//Test 0
//    assertEquals(true, game.isWon(1, 1));//Test right, test first
//    assertEquals(true, game.isWon(1, 3));//Test middle
//    assertEquals(true, game.isWon(1, 5));//Test left, test last
//    assertEquals(true, game.isWon(3, 1));//Test down, test first
//    assertEquals(true, game.isWon(5, 1));//Test middle
//    assertEquals(true, game.isWon(7, 1));//Test up, test last
//    assertEquals(true, game.isWon(5, 11));//Test left-up, test last
//    assertEquals(true, game.isWon(3, 9));//Test middle
//    assertEquals(true, game.isWon(1, 7));//Test right-down, test last
//    assertEquals(true, game.isWon(10, 5));//Test down-left, test first
//    assertEquals(true, game.isWon(12, 3));//Test middle
//    assertEquals(true, game.isWon(14, 1));//Test up-right, test first   
//  }
//  
}
