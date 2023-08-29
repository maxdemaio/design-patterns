package com.maxdemaio.extractBehavoir;

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
}
