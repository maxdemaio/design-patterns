package com.maxdemaio.factoryPattern.creators;

import com.maxdemaio.factoryPattern.products.ChicagoStyleCheesePizza;
import com.maxdemaio.factoryPattern.products.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else {
            return null;
        }
    }
}
