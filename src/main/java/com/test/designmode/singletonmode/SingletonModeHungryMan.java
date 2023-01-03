
package com.test.designmode.singletonmode;

public class SingletonModeHungryMan {
    private static SingletonModeHungryMan singletonMode = new SingletonModeHungryMan();

    private SingletonModeHungryMan(){}

    public static SingletonModeHungryMan getInstance(){
        return singletonMode;
    }
}
