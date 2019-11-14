import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A class representing a railyard with classification yards that sorts train cars.
 * @author Andrea Tongsak
 */ 
public class RailYard<T extends Comparable<? super T>> {
  
  /** Stores the yards used during sorting. */
  private ArrayList<ClassificationYard<T>> classificationYards;
  
  /**
   * Constructor for RailYard creating an ArrayList of CollectionYards and stores it
   * @param railArray an array of ints, for each integer represents a collection yard with int number of tracks
   */ 
  public RailYard (int[] yards) {
    if (yards.length < 1) {
      System.out.println("RailYard needs at least 1 collection yard, please input another value.");
    }
    classificationYards = new ArrayList<ClassificationYard<T>>(yards.length);
    
    /** runs through RailYard and checks for tracks */
    for (int i = 0; i < yards.length; i++) {
      if (yards[i] <= 1) {
        System.out.println("CollectionYard needs at least 1 track, please input another value.");
      } else {
        classificationYards.add(new ClassificationYard<T>(yards.length));
      }
    }
  }
  
  /**
   * Takes in which sort (cycle or closest), number of classification yards, number of tracks (for each yard), and various strings
   * Also checks validity of command line arguments
   * 
   */ 
  public static void main(String[] args) {
    
    /** Check length of args first */
    if (args.length == 0) {
      System.out.println("You entered no input!");
    } 
    
    /** reading the Type of Sort */
    String sortTypeInput = args[0];
    // exceptions: if user did not input cycle or closest
    if (sortTypeInput != "cycle" || sortTypeInput != "closest") {
      System.out.println("You entered the wrong input for Sort, please input either 'cycle' or 'closest'!");
    } else {
      String sortType = args[0];
    }
    
    /** reading the Number of Classification Yards */  
    int numOfYards = 0;
    
    try {
      numOfYards = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) {
      // try again as a double
      try {
        numOfYards = (int)(Double.parseDouble(args[1]) + 0.5);
      } catch (NumberFormatException e2) { 
        // it is not an int or double
        System.out.println("You didn't enter a number for Classification Yards!");
      }
    }
    
    /** read the Number of Tracks (for each yard) */
    int count = 0;
    Map<String, Integer> yard = new HashMap<String, Integer>();
    // check for correct number of inputs 
    for (int i = 1; i < (numOfYards-1); i++) {
      try {
        // starting count of args after 1, assigning the values to a new variable
        yard.put("yard" + i, Integer.parseInt(args[1 + i]));
        count++;
      } catch (NumberFormatException e3) {
        try {
          yard.put("yard" + i, (int)Double.parseDouble(args[1 + i] + 0.5));
          count++;
        } catch (NumberFormatException e4) {
          // not an int or double
          System.out.println("You didn't enter a number of the tracks!");
        }
      }
    }
    
    if (count != numOfYards) {
      System.out.println("You didn't enter enough tracks for the number of yards specified!");
    }
    
    
    

  }
  
  /**
   * Takes an incoming train as an array and sorts it by closest algorithm. Places each car on a track of classification yard
   * @param train (ArrayList) to be sorted
   */ 
  public void cycleSort(T[] train) {
    for (ClassificationYard<T> yard : classificationYards) {
      yard.cycleSort(train);
    }
  }
  
  /**
   * Takes an incoming train as a LinkedList
   */ 
  public void cycleSort(List<T> train) {
    for (ClassificationYard<T> yard: classificationYards) {
      yard.cycleSort(train);
    }
  }
  
  public void closestSort(T[] train) {
    for (ClassificationYard<T> yard : classificationYards) {
      yard.closestSort(train);
    }
  }
  
  public void closestSort(List<T> train) {
    for (ClassificationYard<T> yard : classificationYards) {
      yard.closestSort(train);
    }
    
  }
  
}