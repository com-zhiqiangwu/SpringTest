package com.test.reflect;

public class Reflect {
    public String  constructorName;
    public String propertyName;
    public String methodName;
    public int constructorNum;
    public int propertyNum;
    public int methodNum;
    public boolean flag;

    public Reflect() {
        System.out.println("公共无参方法");
    }

    public Reflect(String constructorName) {
        this.constructorName = constructorName;
        System.out.println("默认构造方法:"+constructorName);
    }


    public Reflect(int constructorNum) {
        this.constructorNum = constructorNum;
        System.out.println("一个参数构造方法");
    }

    public Reflect(String constructorName, String propertyName, String methodName) {
        this.constructorName = constructorName;
        this.propertyName = propertyName;
        this.methodName = methodName;
        System.out.println("多个参数构造方法");
    }

    protected  Reflect(String methodName,int methodNum){
        System.out.println("受保护的构造方法");

    }
    private Reflect(boolean flag){
        System.out.println("私有构造方法");
    }


    public String getConstructorName() {
        return constructorName;
    }

    public void setConstructorName(String constructorName) {
        this.constructorName = constructorName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getConstructorNum() {
        return constructorNum;
    }

    public void setConstructorNum(int constructorNum) {
        this.constructorNum = constructorNum;
    }

    public int getPropertyNum() {
        return propertyNum;
    }

    public void setPropertyNum(int propertyNum) {
        this.propertyNum = propertyNum;
    }

    public int getMethodNum() {
        return methodNum;
    }

    public void setMethodNum(int methodNum) {
        this.methodNum = methodNum;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
