package com.maxdemaio.decoratorPattern;

// Concrete Decorator
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        // We want it to include the beverage and mocha
        // So we delegate the call to the object we're decorating
        // then we add ", Mocha"
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        // delegate the call to the object we're decorating
        // then we add the cost of mocha to the result
        return 0.20 + beverage.cost();
    }
}
