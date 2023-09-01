package com.maxdemaio.decoratorPattern;

// Concrete Decorator
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        // We want it to include the beverage and mocha
        // So we delegate the call to the object we're decorating
        // then we add ", Whip"
        return beverage.getDescription() + ", Whip";
    }

    public double cost() {
        // delegate the call to the object we're decorating
        // then we add the cost of whip to the result
        return 0.10 + beverage.cost();
    }
}
