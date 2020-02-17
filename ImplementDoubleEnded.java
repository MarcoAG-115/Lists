import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;

/**
 * ImplementDoubleEnded.java.
 * 
 *
 * @author Marco Gonzalez (mag0089@auburn.edu)
 * @version TODAY
 */
public class ImplementDoubleEnded<T> implements DoubleEndedList<T> {
 
   // Instance Variables
   
   private Node first;
   private Node last;
   private int size ;
   
   // Constructor
   
   public ImplementDoubleEnded() {
   
      first = null;
      size = 0;
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
   
      private Node elem1 = first;
   
   // Methods
   
      public boolean hasNext() {
      
         return elem1 != null;
      }
   
      public T next() {
      
         if (!(hasNext())) {
         
            throw new NoSuchElementException();   
         }
      
         T elem2 = elem1.element;
         elem1 = elem1.next;
      
         return elem2;
      }
   
      public void remove() {
      
         throw new UnsupportedOperationException();
      }
   }

// Node Class

   private class Node {
   
   // Instance Variables
   
      private Node next;
      private T element;
   
      public Node(T elem) {
      
         element = elem;
      }
   
      public Node(Node nxt, T elem) {
      
         next = nxt;
         element = elem;
      }
   }
   
   // Methods for DoubleEnded
   
   /**
 * Adds element to the front of the list. If element is null,
 * this method throws an IllegalArgumentException.
 */
   public void addFirst(T element) {
   
      if (element == null) {
      
         throw new IllegalArgumentException();
      }
   
      Node temp = new Node(element);
   
      if (size() == 0) {
      
         last = temp;
         first = temp;
      
      }
      else {
      
         temp.next = first;
         first = temp;
      }
      size = size + 1;
   }
   
/**
 * Adds element to the end of the list. If element is null,
 * this method throws an IllegalArgumentException.
 */
   public void addLast(T element) {
   
      if (element == null) {
      
         throw new IllegalArgumentException();
      }
   
      Node temp = new Node(element);
      temp.element = element;
   
      if (size() == 0) {
      
         last = temp;
         first = temp;
      }
      else {
      
         last.next = temp;
         last = temp;
      }
      size = size + 1;
   }
      
/**
 * Delete and return the element at the front of the list.
 * If the list is empty, this method returns null.
 */
   public T removeFirst() {
   
      if (size() == 0) {
      
         return null;
      }
   
      T remove = first.element;
      first = first.next;
      size = size - 1;
   
      return remove;
   }
   
/**
 * Delete and return the element at the end of the list.
 * If the list is empty, this method returns null.
 */
   public T removeLast() {
   
      if (size() == 0) {
      
         return null;
      }
      else if (size() == 1) {
      
         T remove = first.element;
         first = null;
         last = null;
         size = size - 1;
         return remove;
      }
      else {
      
         Node temp = first;
      
         while (temp.next.next != null) {
         
            temp = temp.next;
         }
      
         T remove = temp.next.element;
         temp.next = null;
         last = temp;
         size = size - 1;
      
         return remove; 
      }
   }
 
}