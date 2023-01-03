package com.test.designmode.easyfactorymode;

public class PizzaStore {
    private PizzaFactory pizzaFactory;

    public PizzaStore(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza makePizza(String type){
        Pizza pizzaInstance = pizzaFactory.createPizzaInstance(type);
        pizzaInstance.prepared();
        pizzaInstance.bake();
        pizzaInstance.cut();
        pizzaInstance.box();
        return pizzaInstance;
    }
}
