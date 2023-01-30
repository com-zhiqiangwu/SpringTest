package com.test.exception.finallytest;

public class BreakTest {

    public void testBreak(){
        for (int i = 0; i < 3; i++) {
            try {
                if (i==0){
                    break;
                }
                System.out.println(i);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("执行了finally语句");
            }
        }
    }
}
