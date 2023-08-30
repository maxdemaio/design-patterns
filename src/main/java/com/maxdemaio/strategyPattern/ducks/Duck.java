package com.maxdemaio.strategyPattern.ducks;

import com.maxdemaio.strategyPattern.encapsulatedBehavior.FlyBehavior;
import com.maxdemaio.strategyPattern.encapsulatedBehavior.QuackBehavior;

public abstract class Duck {
    public QuackBehavior quackBehavior;
    public FlyBehavior flyBehavior;

    public Duck() {
    }

    void swim() {
        System.out.println("swimming!");
    }

    public abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    // Setting behavior dynamically
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}
