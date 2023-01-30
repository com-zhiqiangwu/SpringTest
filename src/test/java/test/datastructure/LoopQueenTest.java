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
        HashMap<Object, Object> map = new HashMap<Object,Object>(){{
            put("student1","张三");
            put("student2","李四");
            put("student3","王五");
            put("student4","赵六");
        }};
        System.out.println(map);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("student1","张三");
        objectObjectHashMap.put("student2","李四");
        objectObjectHashMap.put("student3","王五");
        objectObjectHashMap.put("student4","赵六");
        System.out.println(objectObjectHashMap);
        System.out.println(3*0.1==0.3);
    }
}
