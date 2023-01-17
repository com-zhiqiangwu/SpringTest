package test.datastructure;

import com.test.datastructure.LoopQueen;
import org.junit.Test;

import java.util.HashMap;

public class LoopQueenTest {

    @Test
    public void test1(){
        LoopQueen loopQueen = new LoopQueen(5);
        loopQueen.enqueen(2);
        loopQueen.outPut();
        System.out.println();
        loopQueen.enqueen(5);
        loopQueen.outPut();
        System.out.println();
        loopQueen.enqueen(7);
        loopQueen.outPut();
        System.out.println();
        loopQueen.enqueen(8);
        loopQueen.outPut();
        System.out.println();

        int dequeen = loopQueen.dequeen();
        System.out.println(dequeen);
        int dequeen1 = loopQueen.dequeen();
        System.out.println(dequeen1);
        int dequeen2 = loopQueen.dequeen();
        System.out.println(dequeen2);
        int dequeen3 = loopQueen.dequeen();
        System.out.println(dequeen3);
        int dequeen4 = loopQueen.dequeen();
        System.out.println(dequeen4);

    }

    @Test
    public void test2(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(1<<30);
        System.out.println( );
    }
}
