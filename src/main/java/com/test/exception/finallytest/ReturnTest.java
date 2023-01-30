package com.test.exception.finallytest;

public class ReturnTest {


    /**
     * finally语句块是在return执行后，返回前执行的
     * @return
     */
    public int testReturn(){

        int i=1;
        try {
            System.out.println("try...");
            i+=10;
            return i;
        } catch (Exception e) {
            System.out.println("catch...");
            return i;
        } finally {
            i++;
            System.out.println("finally......");
            System.out.println(i);
        }
    }
}
