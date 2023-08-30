package com.maxdemaio.strategyPattern.encapsulatedBehavior;

public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("Silence");
    }
}