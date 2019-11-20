import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*******************************************************************************************************
 * RailYard Class represents a rail yard with classification yard to sort cars of the incoming trains.
 *
 * @author Andrea S Tongsak
 *******************************************************************************************************/

public class RailYard<T extends Comparable<? super T>> {

    /***
     * classYard is used for sorting train cars.
     ***/
    private ArrayList<ArrayList<LinkedList<T>>> classYard;

    /***
     * Constructor creates an ArrayList of classification yards and stores it in classYards
     *
     * @param yards an array of ints that for each integer indicates a collection yard with int number of tracks
     ***/
    public RailYard(int[] yards) {

        if (yards.length < 1) {
            System.out.println("Incorrect Entry of number of Yards. Rail Yard was not created.");
        }

        if (yards.length == 1 && yards[0] <= 1) {
            System.out.println("CollectionYard must have at least one track. CollectionYard was not created.");
        }

        // classYard is a two-dimensional ArrayList
        classYard = new ArrayList<ArrayList<LinkedList <T>>>(yards.length);

        for (int i = 0; i < yards.length; i++){
            classYard.add(new ArrayList<LinkedList<T>>(yards[i]));
            for (int j = 0; j < yards[i]; j++) {
                classYard.get(i).add(new LinkedList<T>());
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
        // smallest viable case is when user gives type and one track (so
        if (args.length < 3) {
            System.out.println("You entered the wrong length for input!");
            return;
        }

        /** reading the Type of Sort */
        String sortTypeInput = args[0];
        // exceptions: if user did not input cycle or closest
        if (sortTypeInput.equals("cycle") || sortTypeInput.equals("closest")) {
            // pass sortTypeInput into class for sorting; after checking
        } else {
            System.out.println("You entered the wrong input for Sort, please input either 'cycle' or 'closest'!");
            return;
        }

        /** reading the Number of Classification Yards */
        int numOfYards = 0;

        try {
            numOfYards = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("You didn't enter a correct input for Classification Yards!");
        }

        /** read the Number of Tracks (for each yard) */
        int count = 0;
        int place = 0;
        // stores the yard array of ints
        int[] yardInput = new int[numOfYards];

        // check for correct number of inputs
        for (int i = 0; i < numOfYards; i++) {
            try {
                // starting count of args after 1, assigning the values to a new variable
                yardInput[i] = Integer.parseInt(args[2 + i]);
                count++;
                place = 2 + i;
            } catch (NumberFormatException e3) {
                // not an int
                System.out.println("You didn't enter a valid number for the tracks!");
            }
        }
        
        // makes sure that the each yard had the track specified
        if (count != numOfYards) {
            System.out.println("You didn't enter enough tracks for the number of yards specified!");
            return;
        }

        /** read the Train stream input */

        // stores the new array
        List<String> unsortedList = new ArrayList<String>();
      
        // need a variable that keeps track of place in args input, reading train
        for (int j = place + 1; j < args.length; j++) {
          try {
            unsortedList.add(args[j]);
          } catch (IndexOutOfBoundsException e4) {
            System.out.println("You didn't enter a train!");
            return;
          }

        }
        
        
        System.out.println("pre sort:" + unsortedList);
        
        /** Pass all variables into the proper methods! Must first create an instance of the Railyard class. */
        if (sortTypeInput.equals("cycle")) {
          new RailYard<String>(yardInput).cycleSort(unsortedList);
        } else if (sortTypeInput.equals("closest")) {
          new RailYard<String>(yardInput).closestSort(unsortedList);
        }
        
        System.out.println("post sort:" + unsortedList);
        
    }
    

    /**
     * getYard returns the classYard of the RailYard class.
     *         the outermost ArrayList<> represents classification/collection of yards,
     *         the next inner level ArrayList<> represents yard of tracks, and
     *         the innermost LinkedList<T> represents track of cars.
     * @return The classYard of the RailYard class as a two-dimensional ArrayList.
     */
    public ArrayList<ArrayList<LinkedList<T>>> getYard() {
        return classYard;
    }


    /**
     * cycleSort takes an array of generic type, and sorts the array using cycle sort algorithm,
     * which places car after preceding car if of greater or equal value, or the next track if less.
     * if there is no next track then add the car to the 1st track.
     * @param train is the input array to sort.
     */
    public void cycleSort(T[] train){
        int tracks;                                                  // number of tracks in the yard
        int trainLength = train.length;                              // length of the train
        ArrayList<T> mergedTrain = new ArrayList<T>(trainLength);    // holds the train cars after sorted
        int trackPosition = 0;                                       // keep track of track position

        // loop through every yard.
        for (int i = 0; i < getYard().size(); i++) {
            // get the tracks in the yard
            tracks = getYard().get(i).size();
            
            // handles if train is empty
            if (trainLength == 0) {
              return;
            }  
            
            // then loop through every car in the train and finds a track.
            for (int j = 0; j < train.length; j++) {
                // add car to the 1st track
                if (j == 0) {
                    getYard().get(i).get(0).add(0, train[j]);
                }
                // if we still have car in the train
                else if (train[j] != null) {
                    // if the car is greater than or equal to the car that preceded it in the train
                    // add the car to that track
                    if (train[j].compareTo(train[j-1]) >= 0) {
                        getYard().get(i).get(trackPosition).add(0, train[j]);
                    }
                    // if not then add the car to the right next track
                    else if (train[j].compareTo(train[j-1]) < 0) {
                        // if there is still next track then add the car to that next track
                        // and set track position to that next track
                        if (trackPosition+1<tracks) {
                            trackPosition++;
                            getYard().get(i).get(trackPosition).add(0, train[j]);
                        }
                        // if there is no next track then add the car to the 1st track
                        // and set track position to the 1st track
                        else if (trackPosition+1 >= tracks) {
                            trackPosition = 0;
                            getYard().get(i).get(0).add(0, train[j]);
                        }
                    }
                }
            }
            // merging the train cars and be ready for next yard
            mergedTrain = merge(i, trainLength);
            for (int q = 0; q < trainLength; q++) {
                train[q] = mergedTrain.get(q);
            }
        }
    }

    /**
     * cycleSort takes an List of generic type, and sorts the Linkedlist using cycle sort algorithm,
     * which places car after preceding car if of greater or equal value, or the next track if less.
     * if there is no next track then add the car to the 1st track
     * @param train is the input LinkedList to sort.
     */
    public void cycleSort(List<T> train) {
        int tracks;                                                 // number of tracks in the yard
        int trainLength = train.size();                             // length of the train
        ArrayList<T> mergedList = new ArrayList<T>(trainLength);    // holds the train cars after sorted
        int count = 0;
        
        // if the train is empty, must check first before setting next and previous
        // handles if train is empty
        if (train.size() == 0) {
          return;
        }
        
        T next;                                                     // for next train car position
        T previous = train.get(0);                                  // for previous train car position
        int trackPosition = 0;                                      // keep track of track position

        // loop through every yard.
        for (int i = 0; i < getYard().size(); i++) {
            
            tracks = getYard().get(i).size();

            // then loop through every car in the train and finds a track.
            for (T t : train) {
                next = t;
                // add car to the 1st track
                if (count == 0) {
                    getYard().get(i).get(0).add(0, next);
                    count++;
                }
                // if we still have car in the train
                else if (count != 0) {
                    // if the car is greater than or equal to the car that preceded it in the train
                    // add the car to that track
                    if (next.compareTo(previous) >= 0) {
                        getYard().get(i).get(trackPosition).add(0, next);
                    }
                    // if not then add the car to the right next track
                    else if (next.compareTo(previous) < 0) {
                        // if there is still next track then add the car to that next track
                        // and set track position to that next track
                        if (trackPosition + 1 < tracks) {
                            trackPosition++;
                            getYard().get(i).get(trackPosition).add(0, next);
                        }
                        // if there is no next track then add the car to the 1st track
                        // and set track position to the 1st track
                        else if (trackPosition + 1 >= tracks) {
                            trackPosition = 0;
                            getYard().get(i).get(0).add(0, next);
                        }
                    }
                }
                previous = next;
            }
            // merging the train cars and be ready for next yard
            mergedList = merge(i, trainLength);
            for (int q = 0; q < trainLength; q++) {
                train.set(q, mergedList.get(q));
            }
            // reset key tracking variables
            count = 0;
            trackPosition = 0;
        }
    }

    /**
     * closestSort takes an array of generic type, and sorts the array using closest sort algorithm, which
     *             places car after largest smaller value, or to empty track if smaller than all tail cars.
     * @param train The inputting array to sort.
     */
    public void closestSort(T[] train) {
        int tracks;                                             // number of tracks in the yard
        int length = train.length;                              // length of the train
        ArrayList<T> mergedList;                                // holds the train cars after sorted

        boolean small = false;
        boolean empty = false;
        boolean larger = false;
        boolean smallOnce = false;
        boolean largeOnce = false;
        T smallest;
        T largest;
        int indexS = 0;
        int indexE = 0;
        int indexF = 0;

        // loop through all yards
        for (int i = 0; i < getYard().size(); i++) {
            tracks = getYard().get(i).size();
            
            // handles if train is empty
            if (length == 0) {
              return;
            }  
            
            //loops through every car in the train.
            for (T t : train) {
                smallest = t;
                largest = t;
                //loops through every track to find smallest, largest, and empty track compared to train at j.
                for (int k = 0; k < tracks; k++) {
                    // if track k is not empty and the first car in that track is not null
                    if (!getYard().get(i).get(k).isEmpty() && getYard().get(i).get(k).get(0) != null) {
                        // if car in the track is less than or equal to the train car
                        if (getYard().get(i).get(k).get(0).compareTo(t) <= 0) {
                            // if the train car is equal to the smallest car and never been smallest
                            // take the first car of yard i track k as the smallest
                            if (smallest.equals(t) && !smallOnce) {
                                smallest = getYard().get(i).get(k).get(0);
                                indexS = k;
                                small = true;
                                smallOnce = true;
                            }
                            // else if the last car in yard i track k the is less than or equal to the smallest
                            // take the last car of yard i track k as smallest
                            else if (smallest.compareTo(getYard().get(i).get(k).getFirst()) <= 0) {
                                smallest = getYard().get(i).get(k).getFirst();
                                indexS = k;
                                small = true;
                            }
                        }
                        // if the last car of yard i track k is larger than the train car
                        // take the last car of yard i track k as the largest
                        if (this.getYard().get(i).get(k).getFirst().compareTo(t) > 0) {
                            // if the train car is equal to the largest car and never been the largest
                            // take the ;ast car of yard i track k as the largest
                            if (largest.equals(t) && !largeOnce) {
                                largest = getYard().get(i).get(k).getFirst();
                                indexF = k;
                                larger = true;
                                largeOnce = true;
                            }
                            // else if the last car in yard i track k the is larger than or equal to the largest
                            // take the last car of yard i track k as largest
                            else if (largest.compareTo(getYard().get(i).get(k).getFirst()) >= 0) {
                                largest = getYard().get(i).get(k).getFirst();
                                indexF = k;
                                larger = true;
                            }
                        }
                    }
                    // if track k is empty then set proper values to control variables
                    else if (getYard().get(i).get(k).isEmpty() && !empty) {
                        indexE = k;
                        empty = true;
                    }
                }
                // add train car according to appropriate track
                if (small) {
                    getYard().get(i).get(indexS).add(0, t);
                } else if (empty) {
                    getYard().get(i).get(indexE).add(0, t);
                } else if (larger) {
                    getYard().get(i).get(indexF).add(0, t);
                }
                // reset control variables
                small = false;
                empty = false;
                larger = false;
                smallOnce = false;
                largeOnce = false;
            }
            // merging the train cars and be ready for next yard
            mergedList = merge(i, length);
            for (int q = 0; q <length; q++) {
                train[q] = mergedList.get(q);
            }
        }
    }

    /**
     * closestSort takes a list of generic type, and sorts the list using closest sort algorithm, which
     *             places car after largest smaller value, or to empty track if smaller than all tail cars.
     * @param train The inputting list to sort.
     */
    public void closestSort(List<T> train) {
        int tracks;                                             // number of tracks in the yard
        T next;                                                 // for train car position
        int length = train.size();                              // length of the train
        ArrayList<T> mergedList;                                // holds the train cars after sorted

        boolean small = false;
        boolean empty = false;
        boolean larger = false;
        boolean smallOnce = false;
        boolean largeOnce = false;
        T smallest;
        T largest;
        int indexS = 0;
        int indexE = 0;
        int indexF = 0;

        // loop through all yards
        for (int i = 0; i < getYard().size(); i++) {
            tracks = getYard().get(i).size();
            
            // handles if train is empty
            if (length == 0) {
              return;
            }  
            
            //loops through every car in the train.
            for (T t : train) {
                next = t;                     // holds the train car
                smallest = next;              // initialize smallest
                largest = next;               // initialize largest
                //loops through every lane to find the smallest, largest and empty track compared to train at j.
                for (int k = 0; k < tracks; k++) {
                    // if yard i track k is empty
                    if (!getYard().get(i).get(k).isEmpty()) {
                        // if car in the track is less than or equal to the train car
                        if (getYard().get(i).get(k).getFirst().compareTo(next) <= 0) {
                            // if the train car is equal to the smallest car and never been smallest
                            // take the first car of yard i track k as the smallest
                            if (smallest.equals(next) && !smallOnce) {
                                smallest = getYard().get(i).get(k).getFirst();
                                indexS = k;
                                small = true;
                                smallOnce = true;
                            }
                            // else if the last car in yard i track k the is less than or equal to the smallest
                            // take the last car of yard i track k as smallest
                            else if (smallest.compareTo(getYard().get(i).get(k).getFirst()) <= 0) {
                                smallest = getYard().get(i).get(k).getFirst();
                                indexS = k;
                                small = true;
                            }
                        }
                        // if the last car of yard i track k is larger than the train car
                        // take the last car of yard i track k as the largest
                        if (this.getYard().get(i).get(k).getFirst().compareTo(next) > 0) {
                            if (largest.equals(next) && !largeOnce) {
                                largest = getYard().get(i).get(k).getFirst();
                                indexF = k;
                                larger = true;
                                largeOnce = true;
                            }
                            // else if the last car in yard i track k the is larger than or equal to the largest
                            // take the last car of yard i track k as largest
                            else if (largest.compareTo(getYard().get(i).get(k).getFirst()) >= 0) {
                                largest = getYard().get(i).get(k).getFirst();
                                indexF = k;
                                larger = true;
                            }
                        }
                    }
                    // if track k is empty then set proper values to control variables
                    else if (getYard().get(i).get(k).isEmpty() && !empty) {
                        indexE = k;
                        empty = true;
                    }
                }
                // add train car according to appropriate track
                if (small) {
                    getYard().get(i).get(indexS).add(0, next);
                } else if (empty) {
                    getYard().get(i).get(indexE).add(0, next);
                } else if (larger) {
                    getYard().get(i).get(indexF).add(0, next);
                }
                // reset control variables
                small = false;
                empty = false;
                larger = false;
                smallOnce = false;
                largeOnce = false;
            }
            mergedList = merge(i, length);
            for (int q = 0; q <length; q++) {
                train.set(q, mergedList.get(q));
            }
        }
    }

    /****************************************************************************************************************
     * Merge Algorithm: Until all the tracks are empty, the front car of each track is considered and of those cars,
     * the one with the least value is removed and is placed at the back of the train.
     ****************************************************************************************************************/

    /**
     * merge takes the yard#, and length of the train to sort as input and returns
     *       the merged tracks as an ArrayList.
     * @param yard The yard# to sort.
     * @param length The length of the train
     * @return The merged yard represented as an ArrayList.
     */
    public ArrayList<T> merge (int yard, int length) {
        int tracks = getYard().get(yard).size();                        // holds number of tracks in the yard
        T smallest = getYard().get(yard).get(0).getLast();              // holds the car with the smallest value
        int index = 0;                                                  // hold what track we are at
        ArrayList<T> mergedTrain = new ArrayList<T>(length);            // holds the merged train cars

        //loops through the length of the train, because that's how many spots to fill.
        for (int j = 0; j <length; j++) {

            //loops through every track to find the smallest value to add to the ArrayList.
            for (int i = 0; i < tracks; i++) {
                // if the track is not empty
                if (!getYard().get(yard).get(i).isEmpty()) {
                    // if the track i of the yard has more than one car in there
                    if (getYard().get(yard).get(i).size() > 1){
                        // if smallest is smaller than the car from the track
                        // then make that car in the track be smallest one
                        if (smallest.compareTo(getYard().get(yard).get(i).getLast()) > 0) {
                            smallest = getYard().get(yard).get(i).getLast();
                            index = i;
                        }
                    }
                    // if there is only one car in the track i of the yard and that value is not null
                    else if (getYard().get(yard).get(i).size() == 1 &&
                            getYard().get(yard).get(i).getFirst() != null) {
                        // if smallest is smaller than the car the 1st car of the track i
                        // then make that car in the track be smallest one
                        if (smallest.compareTo(getYard().get(yard).get(i).getFirst()) > 0) {
                            smallest = getYard().get(yard).get(i).getFirst();
                            index = i;
                        }
                    }
                }
                // if the track is empty then do nothing
                else if (getYard().get(yard).get(i).isEmpty()) {
                }
            }

            // add smallest car to the merged train
            mergedTrain.add(smallest);
            // if the track is not empty yet then remove last car from the track
            if (!getYard().get(yard).get(index).isEmpty()) {
                getYard().get(yard).get(index).removeLast();
            }

            // look for the smallest element among all tracks.
            for (int k = 0; k < tracks; k++) {
                if (!getYard().get(yard).get(k).isEmpty()) {
                    smallest = getYard().get(yard).get(k).getLast();
                    index = k;
                }
            }
        }
        return mergedTrain;
    }



}