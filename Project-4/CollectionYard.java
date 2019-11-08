import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class CollectionYard represents an ArrayList of LinkedLists of type T
 * Each linked list represents a track in the collection yard where trains can be sorted
 * @author Andrea Tongsak
 */ 
public class CollectionYard<T extends Comparable<? super T>> {
  
  /** Stores tracks */ 
  private ArrayList<LinkedList<T>> tracks;
  
  /**
   * Constructor takes the int number of tracks in collection yard and creates LinkedList in the ArrayList
   * @param tracks the number of tracks in collection yard
   */ 
  public CollectionYard(int numTracks) {
    tracks = new ArrayList<LinkedList<T>>(numTracks);
    // runs the number of tracks in collection yard adding linked lists
    for (int i = 0; i < numTracks; i++) {
      tracks.add(new LinkedList<T>());
    }
  }
  
  /**
   * Cycle sorts the train by placing cars in order on track until a train is smaller or yard is out of tracks
   * @param train the train (array of type T) to be sorted
   */ 
  public void cycleSort(T[] train) {
    int length = train.length;
    LinkedList<T> listToSort = new LinkedList<T>();
    // loops through each train and assigns car to train
    for (T car : train) {
      listToSort.add(car);
    }
    this.cycleSort(listToSort);
    Iterator<T> ptr = listToSort.iterator();
    // sorts through every train 
    for (int i = 0; i < length; i++) {
      if (ptr.hasNext()) {
        train[i] = ptr.next();
      }
    }
  }
  
  /**
   * Cycle sorts the train
   * @param train the train (LinkedList of type T) to be sorted 
   */ 
  public void cycleSort(LinkedList<T>) {
    
  }
  
}