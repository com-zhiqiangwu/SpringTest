package test.datastructure;

import com.test.datastructure.Array;
import org.junit.Test;

import java.util.Arrays;

public class ArrayTest {

    @Test
    public void test1(){
        int size = 0;
        int[] intEnd = new int[10];//定义数组容量为10
        for (int i = 0; i < 5; i++) {
            intEnd[i] = i+1;//赋值
            size++;//元素个数
        }
        int index = size;
        int element = 6;
        Array.addInEnd(intEnd,index,element);
    }

    @Test
    public void test2(){
        //2.中间插入，在数组中间某个位置插入数据，其后数据下标需要向后移动
        int[] intMiddle = new int[10];//定义数组容量为10
        for (int i = 0; i < 7; i++) {
            intMiddle[i] = i+1;//赋值
        }
        int index = 3;//定义在下标为3出插入元素
        int element = 9;//定义要插入的元素
        Array.addInMiddle(intMiddle,index,element);
    }

    @Test
    public void test3(){
        int size = 0;
        int[] intArr = new int[10];
        for (int i = 0; i < 10; i++) {
            intArr[i]=i+1;
            size++;
        }
        System.out.println(Arrays.toString(intArr));
        Array.addResize(intArr,size);
    }

    @Test
    public void test4(){
        int[] intDel = new int[10];
        for (int i = 0; i < 10; i++) {
            intDel[i]=i+1;
        }
        System.out.println("定义删除数组"+Arrays.toString(intDel));
        int delIndex = 3;//要删除元素的下标

        Array.delArr(intDel,delIndex);
    }


}
