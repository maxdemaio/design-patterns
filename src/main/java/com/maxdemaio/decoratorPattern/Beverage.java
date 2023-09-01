package com.maxdemaio.decoratorPattern;

// Component
public abstract class Beverage {
    String description = "beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
