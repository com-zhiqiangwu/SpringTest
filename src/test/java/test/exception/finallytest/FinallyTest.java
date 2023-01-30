package test.exception.finallytest;

import com.test.exception.finallytest.*;
import org.junit.Test;

public class FinallyTest {

    /**
     * finally语句块是在return执行后，返回前执行的
     */
    @Test
    public void test1(){
        ReturnTest returnTest = new ReturnTest();
        int i = returnTest.testReturn();
        System.out.println(i);
    }

    /**
     * finally语句块是在循环被跳过（continue）和中断（break）之前被执行的
     */
    @Test
    public void test2(){
        ContinueTest continueTest = new ContinueTest();
        continueTest.testContinue();//跳过零之后就执行了finally
    }

    /**
     * finally语句块是在循环被跳过（continue）和中断（break）之前被执行的
     */
    @Test
    public void test3(){
        BreakTest breakTest = new BreakTest();
        breakTest.testBreak();
    }

    /**
     * 在finally中修改基本数据类型对返回值的影响
     */
    @Test
    public void test4(){
        ModifyInFinally modifyInFinally = new ModifyInFinally();
        int i = modifyInFinally.testModifyBasicType();
        System.out.println(i);
    }

    /**
     * 在finally中修改引用变量对返回值的影响
     */
    @Test
    public void test5(){
        ModifyInFinally modifyInFinally = new ModifyInFinally();
        StringBuilder stringBuilder = modifyInFinally.testModifyRefType();
        System.out.println(stringBuilder);;
    }

    /**
     * return在finally中对修改基本数据类型的返回值的影响
     */
    @Test
    public void test6(){
        ReturnInFinally returnInFinally = new ReturnInFinally();
        int i = returnInFinally.testModifyBasicType();
        System.out.println(i);
    }

    /**
     * return在finally中对修改引用类型的返回值的影响
     */
    @Test
    public void test7(){
        ReturnInFinally returnInFinally = new ReturnInFinally();
        StringBuilder s = returnInFinally.testModifyRefType();
        System.out.println(s);
    }
}
