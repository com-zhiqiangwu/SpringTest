package com.test.designmode.singletonmode;

public class SingletonModeLazyMan {
    private static SingletonModeLazyMan singletonModeLazyMan = null;

    private SingletonModeLazyMan() {
    }

    public static SingletonModeLazyMan getInstance(){
        if (singletonModeLazyMan == null){
            singletonModeLazyMan = new SingletonModeLazyMan();
        }
        return singletonModeLazyMan;
    }

}
