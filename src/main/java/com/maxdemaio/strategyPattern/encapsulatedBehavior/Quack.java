package com.maxdemaio.strategyPattern.encapsulatedBehavior;

public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack!");
    }
}
