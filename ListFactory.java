/**
 * ListFactory.java.
 * Implements the factory method pattern (https://en.wikipedia.org/wiki/Factory_method_pattern)
 * for lists in this assignment.
 *
 * @author Marco Gonzalez (mag0089@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version TODAY
 */
public class ListFactory {

   /**
    * Return an instance of a class that implements RandomizedList.
    */
   @SuppressWarnings("unchecked")
   public static <T> RandomizedList<T> makeRandomizedList() {
      // Replace the following return statement with one that returns
      // an instance of the class you wrote to implement the
      // RandomizedList interface.
      
      ImplementRandomList<T> newInstance = new ImplementRandomList<T>();
      return newInstance;
   }

   /**
    * Return an instance of a class that implements DoubleEndedList.
    */
   @SuppressWarnings("unchecked")
   public static <T> DoubleEndedList<T> makeDoubleEndedList() {
      // Replace the following return statement with one that returns
      // an instance of the class you wrote to implement the
      // DoubleEndedList interface.
      return null;
   }

}
