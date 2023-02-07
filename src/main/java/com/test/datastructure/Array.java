package com.test.datastructure;




import java.util.Arrays;

public class Array {


    public static void addInEnd(int [] intEnd,int index,int element){
        System.out.println("################################尾部插入################");
        System.out.println(Arrays.toString(intEnd));
        intEnd[index] = element;//最后空闲的尾部插入数据
        System.out.println(Arrays.toString(intEnd));
    }

    public static void addInMiddle(int [] intMiddle,int index,int element){
        System.out.println("################################中间插入################");

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
    }

    public static void addResize(int[] intArr,int size){

        //数组元素个数达到数组最大长度
        if (size>=intArr.length){
            int[] intNew = new int[10 * 2];//扩容二倍
            System.arraycopy(intArr,0,intNew,0,intArr.length);//复制数组:按顺序参数说明:原数组-原数组从哪开始复制-目标数组-复制到目标数组从哪开始-复制原数组多长
            intArr = intNew;
            System.out.println(Arrays.toString(intNew));
            System.out.println(Arrays.toString(intArr));
        }
        intArr[11] = 11;
        System.out.println(Arrays.toString(intArr));
    }

    public static void delArr(int[] intDel,int delIndex){
        if (delIndex<0|| delIndex>intDel.length){
            System.out.println("删除数组下标越界，请重新定义数组下标");
        }else {
            intDel[delIndex]= 0;
            for (int i = delIndex; i <intDel.length-1 ; i++) {
                intDel[i]= intDel[i+1];
                intDel[i+1] = 0;
                System.out.println("####"+Arrays.toString(intDel));
            }
            System.out.println("删除后数组："+Arrays.toString(intDel));
        }
    }

}
