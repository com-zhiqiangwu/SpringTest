package com.test.designmode.singletonmode;

public class SingletonModeDoubleCheckLockLazyMan {
    private static SingletonModeDoubleCheckLockLazyMan singletonModeDoubleCheckLockLazyMan = null;

    private SingletonModeDoubleCheckLockLazyMan(){}

    public static SingletonModeDoubleCheckLockLazyMan getInstance(){

        if (singletonModeDoubleCheckLockLazyMan == null){
            synchronized (SingletonModeDoubleCheckLockLazyMan.class){
                if (singletonModeDoubleCheckLockLazyMan == null){
                    singletonModeDoubleCheckLockLazyMan = new SingletonModeDoubleCheckLockLazyMan();
                }
            }
        }
        return singletonModeDoubleCheckLockLazyMan;
    }
}
