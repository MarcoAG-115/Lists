import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;
/**
 * ImplementRandomList.java.
 * 
 *
 * @author Marco Gonzalez (mag0089@auburn.edu)
 * @version TODAY
 */
 
public class ImplementRandomList<T> implements RandomizedList<T> {
 
      // Instance Variables
   private T[] elementList;
   private int size;
   private static final int STANDARD_LENGTH = 1;
      
      // Constructor
      
      /**
       * Gives elementList a standard object.
       */
   @SuppressWarnings("unchecked")
   public ImplementRandomList() {
       
      elementList = (T[]) new Object[STANDARD_LENGTH];
      size = 0;
       
   }
       
      // Methods for RandomizedList
      
   /**
    * Adds the specified element to this list. If the element is null, this
    * method throws an IllegalArgumentException.
    */
   public void add(T element){
   
      if (element == null) {
         
         throw new IllegalArgumentException();
      }
      
      if (elementList.length == size) {
         
         copy(elementList.length * 2);
      }
      
      elementList[size()] = element;
      size++;
   }
  
   /**
    * Selects and removes an element selected uniformly at random from the
    * elements currently in the list. If the list is empty this method returns
    * null.
    */
   public T remove() {
   
      if (size() == 0) {
      
         return null;
      }
      
      int randomElement = new Random().nextInt(size());
      
      T remove = elementList[randomElement];
      elementList[randomElement] = elementList[size() - 1];
      elementList[size() - 1] = null;
      size--;
      
      if ((size() > 0) && (size() < (elementList.length / 4))) {
         
         copy(elementList.length / 2);
      }
      
      return remove;
   
   }
   
  /**
   * Increases or shortens elementList.
   */
   @SuppressWarnings("unchecked")
   private void copy(int length) {
   
      T[] newArray = (T[]) new Object[length];
         
      for (int i = 0; i < size(); i++) {
      
         newArray[i] = elementList[i];
      }
         
      elementList = newArray;
   }
   
   /**
    * Selects but does not remove an element selected uniformly at random from
    * the elements currently in the list. If the list is empty this method
    * return null.
    */
   public T sample(){
   
      if (size == 0) {
      
         return null;
      }
      
      int randomElement = new Random().nextInt(size());
      
      return elementList[randomElement];
   
   }
   
   // Methods for List
   
   /**
    * Returns the number of elements in this list.
    */
   public int size() {
       
      return size;
       
   }
       
   /**
    * Returns true if this list contains no elements, false otherwise.
    */
   public boolean isEmpty() {
   
      return size == 0;
   }
   
  /**
   * Creates and returns an iterator over the elements of this list.
   */
   public Iterator<T> iterator() {
       
      return new RandomIteration();
   }
   
   // Iteration Class
   
   private class RandomIteration implements Iterator<T> {
      
      // Instance Variables
      private int count = size;
      
      // Methods
      
      /**
       * Checks for next element.
       */
      public boolean hasNext() {
         
         
         return (count > 0);
      }
      
      /**
       * Returns the next element.
       */
      public T next() {
      
         if (!hasNext()) {
         
            throw new NoSuchElementException();
         }
         
         Random r = new Random();
         int num = r.nextInt(count);
         T nextElem = elementList[num];
         
         if ((count - 1) != num) {
         
            elementList[num] = elementList[count - 1];
            elementList[count - 1] = nextElem;
         }
         count--;
         return nextElem;
      }
      
      public void remove() {
      
         throw new UnsupportedOperationException();
      }
   }
   
   
}