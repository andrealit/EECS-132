import java.util.Iterator;
import java.util.NoSuchElementException;

/** A class that iterates over the elements of a linked list 
  * @author Andrea Tongsak
  */
public class LinkedListIterator<T> implements Iterator<T> {
  
  /** Stores the node containing the next value of the iteration */
  private LLNode<T> nodeptr;
  
  /** 
   * Creates an iterator for the linked list
   * @param firstNode the node that we will start the iteration from
   */
  public LinkedListIterator(LLNode<T> firstNode) {
    this.nodeptr = firstNode;
  }
  
  /**
   * Returns whether there is still more data in the list
   * @return true if the iteration is not at the end of the list and false when we are at the end
   */
  public boolean hasNext() {
    return nodeptr != null;
  }
  
  /**
   * Returns the element of the list as we iterate through it.
   * @return the next element as we iterate through the list
   * @throws NoSuchElementException if there are no more elements
   */
  public T next() {
    if (nodeptr == null)
      throw new NoSuchElementException();
    else {
      T save = nodeptr.getElement();
      nodeptr = nodeptr.getNext();
      return save;
    }
  }
}