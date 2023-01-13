package test.datastructure;

import org.junit.Test;

import java.util.Arrays;

public class ArrayTest {

    //数组插入数据
    @Test
    public void test1(){

        System.out.println("################################尾部插入################");
        //1.尾部插入-数组元素未超过数组长度定义
        int[] intEnd = new int[10];//定义数组容量为10
        for (int i = 0; i < 5; i++) {
            intEnd[i] = i+1;//先为数组赋值
        }
        System.out.println(Arrays.toString(intEnd));
        intEnd[5] = 6;//最后空闲的尾部插入数据
        System.out.println(Arrays.toString(intEnd));

        System.out.println("################################中间插入################");
        //2.中间插入，在数组中间某个位置插入数据，其后数据下标需要向后移动
        int[] intMiddle = new int[10];//定义数组容量为10
        for (int i = 0; i < 7; i++) {
            intMiddle[i] = i+1;//赋值
        }
        int index = 3;//定义在下标为3出插入元素
        int element = 9;//定义要插入的元素
        if (index<0 || index>intMiddle.length){
            System.out.println("超出数组实际元素范围，数组下标越界，请重新定义index");
        }else{
            //从右往左循环，将要插入数据下标右侧的数据逐个向右移动1位
            for (int i = (intMiddle.length-1)-1; i >=index ; i--) {
                intMiddle[i+1] = intMiddle[i];
                intMiddle[i] = 0;
                System.out.println("####"+Arrays.toString(intMiddle));
            }
            System.out.println(Arrays.toString(intMiddle));
            intMiddle[index] = element;//腾出的位置放入新元素
            System.out.println(Arrays.toString(intMiddle));
        }

        System.out.println("################################扩容插入################");
        //3.数组扩容插入
        int size = 0;
        int[] intArr = new int[10];
        for (int i = 0; i < 10; i++) {
            intArr[i]=i+1;
            size++;
        }
        System.out.println(Arrays.toString(intArr));
        //数组元素个数达到数组最大长度
       if (size>=intArr.length){
           int[] intNew = new int[10 * 2];//扩容二倍
           System.arraycopy(intArr,0,intNew,0,intArr.length);
           intArr = intNew;
           System.out.println(Arrays.toString(intNew));
           System.out.println(Arrays.toString(intArr));
       }

        System.out.println("################################删除数组################");
       int sizeDel = 0;
        int[] intDel = new int[10];
        for (int i = 0; i < 10; i++) {
            intDel[i]=i+1;
            sizeDel++;
        }
        System.out.println("定义删除数组"+Arrays.toString(intDel));

        int delIndex = 3;//要删除元素的下标
        if (delIndex<0|| delIndex>intDel.length){
            System.out.println("删除数组下标越界，请重新定义数组下标");
        }else {
            for (int i = delIndex; i <intDel.length ; i++) {
                intDel[i-1]= intDel[i];
                intDel[i] = 0;
                System.out.println("####"+Arrays.toString(intDel));
            }
            System.out.println("删除后数组："+Arrays.toString(intDel));
        }


    }
}
