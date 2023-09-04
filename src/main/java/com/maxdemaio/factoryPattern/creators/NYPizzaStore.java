package com.maxdemaio.factoryPattern.creators;

import com.maxdemaio.factoryPattern.products.NYStyleCheesePizza;
import com.maxdemaio.factoryPattern.products.Pizza;

public class NYPizzaStore extends PizzaStore {
    Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else {
            return null;
        }
    }
}
