package test.genericity;

import com.test.genericity.genericityclass.GenericityClass;
import com.test.genericity.genericityinterface.GenericityTest;
import com.test.genericity.genericityinterface.GenericityTest1;
import org.junit.Test;

import java.util.ArrayList;

public class GenericityTest {

    //1.什么是泛型？ 参数化类型
    @Test
    public void test1(){
        //为什么要引用泛型？
        // 泛型的出现还得从集合说起，没有泛型的时候，我们将一个对象存入集合时，集合不care这个对象的数据类型是什么，
        // 当我们再次从这个对象取出来的时候，对象的编译类型会变成Object类型，这时候我们就需要强制类型转换，
        // 但是这种行为每次都要去指定类型进行强制转换，并且有可能强制转换不了，比如我存的是Integer类型，
        // 误转换为String类型，那就可能会引发ClassCastException异常
        ArrayList arrayList = new ArrayList();
        arrayList.add("string");
        arrayList.add(100);
        for (int i = 0; i < arrayList.size(); i++) {
            String s = (String) arrayList.get(i);
            System.out.println(s);
        }

    }


    //泛型特性：只在编译时有效
    @Test
    public void test2(){
        ArrayList<String> stringArrayList = new ArrayList<>();
        Class<? extends ArrayList> stringArrayListClass = stringArrayList.getClass();

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Class<? extends ArrayList> integerArrayListClass = integerArrayList.getClass();

        System.out.println(stringArrayListClass.equals(integerArrayListClass));//true
    }


    //泛型接口
    @Test
    public void test3(){
        //1.未指定具体泛型类型
        com.test.genericity.genericityinterface.GenericityTest<Integer> objectGenericityTest = new com.test.genericity.genericityinterface.GenericityTest<>();
        objectGenericityTest.print(100);

        //2.指定了泛型类型
        GenericityTest1 genericityTest1 = new GenericityTest1();
        genericityTest1.print("100");
    }

    //泛型类
    @Test
    public void test4(){
        GenericityClass<Integer> integerGenericityClass = new GenericityClass<Integer>(123);
        System.out.println(integerGenericityClass.getValue());

        GenericityClass<String> stringGenericityClass = new GenericityClass<>("value");
        System.out.println(stringGenericityClass.getValue());

        System.out.println(integerGenericityClass.getClass().equals(stringGenericityClass.getClass()));
    }

    //类型通配符,泛型方法
    @Test
    public void test5(){
        //当showValue方法没有设定类型通配符上限时，编译报错，设置类型通配符上限为number时，Integer是number子类，编译不会报错
        GenericityClass<Integer> integerGenericityClass = new GenericityClass<>(123);
        Integer integer = integerGenericityClass.showValue(integerGenericityClass);
        System.out.println(integer);
    }

}
