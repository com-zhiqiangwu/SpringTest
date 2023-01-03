package com.test.designmode.easyfactorymode;

public class PizzaFactory {

    public  Pizza createPizzaInstance(String type){
        Pizza pizza = null;

        if ("chesses".equals(type)){
            pizza = new ChessesPizza();
        }else if ("clam".equals(type)){
            pizza = new ClamPizza();
        }else {
            System.out.println("当前不能制作"+type+"类型的披萨");
        }
        return pizza;
    }
}
