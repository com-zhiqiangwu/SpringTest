package com.test.genericity.genericityinterface;

public class GenericityTest1 implements GenericityInterface<String>{
    @Override
    public String print(String s) {
        System.out.println(s);
        return s;
    }
}
