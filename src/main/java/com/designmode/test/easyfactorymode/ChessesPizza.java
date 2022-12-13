package com.designmode.test.easyfactorymode;

public class ChessesPizza implements Pizza{
    @Override
    public void prepared() {
        System.out.println("准备制作芝士披萨");
    }

    @Override
    public void bake() {
        System.out.println("烘烤芝士披萨");
    }

    @Override
    public void cut() {
        System.out.println("切芝士披萨");
    }

    @Override
    public void box() {
        System.out.println("给芝士披萨装盒子");
    }
}
