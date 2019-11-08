import java.util.LinkedList;
import java.util.ArrayList;

/**
 * A class representing a railyard with classification yards that sorts train cars.
 * @author Andrea Tongsak
 */ 
public class RailYard<T extends Comparable<? super T>> {
  
  /** Stores the yards used during sorting. */
  private ArrayList<CollectionYard<T>> collectionYards;
  
  /**
   * Constructor for RailYard creating an ArrayList of CollectionYards and stores it
   * @param railArray an array of ints, for each integer represents a collection yard with int number of tracks
   */ 
  public RailYard (int[] yards) {
    if (yards.length < 1) {
      System.out.println("RailYard needs at least 1 collection yard, please input another value.");
    }
    collectionYards = new ArrayList<CollectionYard<T>>(yards.length);
    
    /** runs through RailYard and checks for tracks */
    for (int i = 0; i < yards.length; i++) {
      if (yards[i] <= 1) {
        System.out.println("CollectionYard needs at least 1 track, please input another value.");
      } else {
        collectionYards.add(new CollectionYard<T>(yards.length));
      }
    }
  }
  
  /**
   * Takes in which sort (cycle or closest), number of classification yards, number of tracks (for each yard), and various strings
   * 
   */ 
  public static void main(String[] args) {
    
  }
  
  /**
   * Takes an incoming train as an array and sorts it by closest algorithm. Places each car on a track of classification yard
   * @param train (ArrayList) to be sorted
   */ 
  public void cycleSort(T[] train) {
    
  }
  
  /**
   * Takes an incoming train as 
   */ 
  public void cycleSort(List<T> train) {
    
  }
  
  public void closestSort(T[] train) {
    
  }
  
  public void closestSort(List<T> train) {
    
  }
  
}