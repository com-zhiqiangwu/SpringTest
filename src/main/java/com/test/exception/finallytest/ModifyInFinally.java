package com.test.exception.finallytest;

public class ModifyInFinally {
    public int testModifyBasicType(){

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

    public StringBuilder testModifyRefType(){

        StringBuilder s = new StringBuilder("hahahah");
        try {
            return s;
        } catch (Exception e) {
            System.out.println("catch...");
            return null;
        } finally {
            s.append("caolu");
            System.out.println("finally......");
        }
    }
}
