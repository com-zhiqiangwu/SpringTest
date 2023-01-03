package com.test.genericity.genericityinterface;

public class GenericityTest<T> implements GenericityInterface<T>{
    @Override
    public T print(T t) {
        System.out.println(t);
    return t;
    }
}
