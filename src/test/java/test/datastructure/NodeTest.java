package test.datastructure;

import com.test.datastructure.MyLinkedList;
import org.junit.Test;

public class NodeTest {

   @Test
    public void test1(){
       MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(1, 0);
        myLinkedList.insert(2, 1);
        myLinkedList.insert(3, 2);
        myLinkedList.insert(4, 2);
       myLinkedList.insert(6, 3);
        myLinkedList.outPut();
       System.out.println();
        myLinkedList.remove(3);
        myLinkedList.outPut();
   }


}
