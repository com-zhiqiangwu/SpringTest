package com.test.designmode.easyfactorymode;

public class ClamPizza implements Pizza{
    @Override
    public void prepared() {
        System.out.println("准备蛤里披萨");
    }

    @Override
    public void bake() {
        System.out.println("烘烤哈利披萨");
    }

    @Override
    public void cut() {
        System.out.println("切哈利披萨");
    }

    @Override
    public void box() {
        System.out.println("给哈利披萨装盒子");
    }
}
