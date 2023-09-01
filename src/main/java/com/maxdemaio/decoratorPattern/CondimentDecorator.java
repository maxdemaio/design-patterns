package com.maxdemaio.decoratorPattern;

// Decorator
// Needs to be interchangeable with Beverage, so we extend it
public abstract class CondimentDecorator extends Beverage {
    // Condiment decorators re-implement the getDescription method
    public abstract String getDescription();
}
