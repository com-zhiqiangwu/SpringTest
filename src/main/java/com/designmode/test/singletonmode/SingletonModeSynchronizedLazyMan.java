package com.designmode.test.singletonmode;

public class SingletonModeSynchronizedLazyMan {
    private static  SingletonModeSynchronizedLazyMan singletonModeSynchronizedLazyMan = null;

    public SingletonModeSynchronizedLazyMan() {
    }

    public static synchronized SingletonModeSynchronizedLazyMan getInstance(){
        if (singletonModeSynchronizedLazyMan == null){
            singletonModeSynchronizedLazyMan = new SingletonModeSynchronizedLazyMan();
        }
        return singletonModeSynchronizedLazyMan;
    }
}
