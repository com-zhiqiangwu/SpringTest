package com.test.exception.finallytest;

public class ContinueTest {

    public void testContinue(){
        for (int i = 0; i < 3; i++) {
            try {
                if (i==0){
                    continue;
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
