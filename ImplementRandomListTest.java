import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ImplementRandomListTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   @Test public void addTest1() {
      ImplementRandomList<Integer> list = new ImplementRandomList<Integer>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);
      list.add(6);
      list.add(7);
      
      int expected = 3;
      int actual = list.size();
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void resizeAddTest() {
      ImplementRandomList<Integer> list = new ImplementRandomList<Integer>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);
      list.add(6);
      
      int expected = 6;
      int actual = list.size();
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void addRemoveTest() {
      ImplementRandomList<Integer> list = new ImplementRandomList<Integer>();
      list.add(1);
      list.remove();
      
      int expected = 0;
      int actual = list.size();
      Assert.assertEquals(expected, actual);
   }
}
