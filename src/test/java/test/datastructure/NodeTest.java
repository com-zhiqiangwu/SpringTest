package test.datastructure;

import com.test.datastructure.MyLinkedList;
import org.junit.Test;

public class NodeTest {

   @Test
    public void test1(){
       MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(1, 0);
       System.out.println();
        myLinkedList.outPut();
        myLinkedList.insert(2, 1);
       System.out.println();
       myLinkedList.outPut();
        myLinkedList.insert(3, 2);
       System.out.println();
       myLinkedList.outPut();
        myLinkedList.insert(4, 2);
       System.out.println();
       myLinkedList.outPut();
       myLinkedList.insert(6, 3);
       System.out.println();
       myLinkedList.outPut();

       System.out.println();
       int old = myLinkedList.updateNode(3, 9);//将6修改为9
       System.out.println(old);
        myLinkedList.outPut();
      /* System.out.println();
        myLinkedList.remove(3);
        myLinkedList.outPut();*/
   }


}
