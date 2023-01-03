package com.test.genericity.genericityclass;

public class GenericityClass<T>{
    private T value;
    public GenericityClass(T value){
        this.value = value;
    }
    public T getValue(){
        return this.value;
    }
}
