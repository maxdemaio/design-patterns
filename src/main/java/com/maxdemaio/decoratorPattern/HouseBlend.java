package com.maxdemaio.decoratorPattern;

// Concrete Component
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "house blend";
    }

    public double cost() {
        return 0.89;
    }
}
