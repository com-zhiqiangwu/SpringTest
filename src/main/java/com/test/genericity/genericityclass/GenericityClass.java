package com.test.genericity.genericityclass;

public class GenericityClass<T>{
    private T value;
    public GenericityClass(T value){
        this.value = value;
    }
    public T getValue(){
        return this.value;
    }

    public <Number> Number showValue(GenericityClass<? extends Number> obj){
        System.out.println(obj.getValue());
        return obj.getValue();
    }
}
