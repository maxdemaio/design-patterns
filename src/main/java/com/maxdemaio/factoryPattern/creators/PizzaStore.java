package com.maxdemaio.factoryPattern.creators;

import com.maxdemaio.factoryPattern.products.Pizza;

public abstract class PizzaStore {
    // Now createPizza is back to being a call to
    // a method in the PizzaStore rather than on a factory object
    // has no idea what kind of pizza was created,
    // but it knows it is a pizza and it prepares, bakes, cuts, and
    // boxes it for Ethan and Joel.
    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // Moved our factory object ot this method
    // Our "factory method" is now abstract in PizzaStore
    // All the responsibility for instantiating Pizzas has been moved
    // into a method that acts asa a factory
    // The factory methods handles object creation and encapsulates it in
    // a subclass. This allows for decoupled client code
    abstract Pizza createPizza(String type);
}
