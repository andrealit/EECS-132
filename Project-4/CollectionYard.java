import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class CollectionYard represents an ArrayList of LinkedLists of type T
 * Each linked list represents a track in the collection yard where trains can be sorted
 * This class takes a list or an array of generics, and will sort in order.
 * 
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
   * "Cycle Sort" the train by placing cars in order on track until a car is smaller or yard is out of tracks. 
   * If a car is smaller, it is placed on next track or, if at end, the first track
   * @param train the unsorted train (array of type T)
   */ 
  public void cycleSort(T[] train) {

    LinkedList<T> listToSort = new LinkedList<T>();
    
    // loops through each train and adds car to train
    for (T car : train) {
      listToSort.add(car);
    }
    this.cycleSort(listToSort);
    Iterator<T> ptr = listToSort.iterator();
    
    // runs through every train and assigns
    for (int i = 0; i < train.length; i++) {
      if (ptr.hasNext()) {
        train[i] = ptr.next();
      }
    }
  }
  
  /**
   * "Cycle Sort" the train by placing cars in order on track until a train is smaller or yard is out of tracks
   * If a car is smaller, it is placed on next track or, if at end, the first track
   * @param train the unsorted train (List of type T)
   */ 
  public void cycleSort(List<T> train) {
    /** pointer to iterate through tracks */
    Iterator<LinkedList<T>> ptr = tracks.iterator();
    
    /** track to place train car */
    LinkedList<T> track = null;
    
    /** checks if move to next track is needed */
    boolean shouldMove = true;
    
    // for each car in the train, add car through tracks in yard and check where to put the car
    for (T car : train) {
      // boolean to stop while loop
      boolean carPlaced = false;
      
      // while car isn't placed, go through tracks and arrange
      while(!carPlaced) {
        
        // move ptr forward if car is smaller
        if (ptr.hasNext() && shouldMove) {
          track = ptr.next();
          shouldMove = false;
        }
        
        // if current track is empty, add car
        if (track.isEmpty()) {
          track.addLast(car);
          carPlaced = true;
        } else {
          
          // checks if current track is less than car, and if not, moves to next track
          if (track.getLast().compareTo(car) <= 0) {
            track.addLast(car);
            carPlaced = true;
          } else if (track.getLast().compareTo(car) > 0) {
            shouldMove = true;
          }
        }
        
        // resets pointer if out of tracks
        if (!ptr.hasNext()) {
          ptr = tracks.iterator();
          if(ptr.hasNext()) {
            track = ptr.next();
            carPlaced = true;
          }
        }
      }
    }
    
    // calls the merge method which takes the tracks of the collectionYard and pulls from them the train cars
    this.merge(train);
    
  }
  
  /**
   * "Closest Sort" the train by placing the current car on the next open track or on a lower number that is closest to 
   * the value of the current car
   * @param train an array representing the unsorted train 
   */
  public void closestSort(T[] train) {
    
    LinkedList<T> listToSort = new LinkedList<T>();
    
    // runs through each train and adds car 
    for (T car : train) {
      listToSort.add(car);
    }
    this.closestSort(listToSort);
    Iterator<T> ptr = listToSort.iterator();
    // runs through every train and assigns
    for (int i = 0; i < train.length; i++) {
      if (ptr.hasNext()) {
        train[i] = ptr.next();
      }
    }
  }
  
  /**
   * "Closest Sort" the train by placing the current car on the next open track or on a lower number that is closest to 
   * the value of the current car
   * @param train representing the unsorted train (List of type T)
   */ 
  public void closestSort(List<T> train) {
    for (T car : train) {
      // iterator for tracks in yard
      Iterator<LinkedList<T>> ptr = tracks.iterator();
      
      // if all tracks are full and not lower than the current placed car on lowest track
      LinkedList<T> lowest = null;
      
      // track upon which the current car should be placed
      LinkedList<T> trackPlace = null;
      
      /**
       * if there is more than one car in the tracks that is lower than the current car, finds the one closest 
       * to the current car
       */ 
      LinkedList<T> closest = null;
      
      // stores boolean to stop loop
      boolean carPlaced = false;
      
      // run through tracks of the yard and checks where to put the car
      while (ptr.hasNext() && !carPlaced) {
        // the track that is being checked currently
        LinkedList<T> track = ptr.next();
        
        // if the track is empty, place the car there
        if (track.isEmpty()) {
          trackPlace = track;
          carPlaced = true;
        } else {
          // if all tracks are full and not lower!
          if (lowest == null) {
            lowest = track;
          } else if (lowest.getLast().compareTo(track.getLast()) > 0) {
            lowest = track;
          }
          // if the track is not empty, determine if it is closest to the current car to be placed
          if (track.getLast().compareTo(car) <= 0) {
            // if closest doesn't exist
            if (closest == null) {
              closest = track;
            }
            // if there is more than one lower than current, pull to current (checks which is closer)
            if (closest.getLast().compareTo(track.getLast()) < 0) {
              trackPlace = track;
              closest = track;
            } else {
              trackPlace = closest;
            }
          }
        }
      }
      // place the car
      if (trackPlace != null) {
        trackPlace.add(car);
      } else {
        lowest.add(car);
      }
      // merge the train back from all of the tracks
      this.merge(train);
      
    }
  }
  
  /**
   * "Merge" takes the tracks of the collection yard that have train cars and takes the lowest car from the front of the 
   * tracks to get a train ordered from lowest to highest.
   * @param train the array of train cars to order
   */ 
  public void merge (List<T> train) {
    // a second train used to store the sorted train while the first train is iterated through
    LinkedList<T> train2 = new LinkedList<T>();
    
    // runs through cars in train
    for (T car : train) {
      
      // LinkedList of track with lowest car
      LinkedList<T> lowest = null; 
      
      // Iterator to go through the tracks
      Iterator<LinkedList<T>> ptr = tracks.iterator();
      
      // run through the tracks and check where to put car
      while (ptr.hasNext()) {
        // the first track to compare against that changes and determines the lowest
        LinkedList<T> toCompare = ptr.next();
        if (!toCompare.isEmpty()) {
          if (lowest == null && toCompare != null) {
            lowest = toCompare;
          }
          try {
            if (toCompare.getFirst().compareTo(lowest.getFirst()) <= 0) {
              lowest = toCompare;
            }
          } catch (Exception e) {
            
          }
        }
      }
      
      // add train to the array the first car from the track that is lowest
      try {
        train2.addLast(lowest.removeFirst());
      } catch (NullPointerException e) { 
          
      }
      
    }
    
    // to sort the initial train variable 
    train.clear();
    for (T car : train2) {
      train.add(car);
    }
    
  }
}