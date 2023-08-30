package com.maxdemaio.strategyPattern.ducks;

import com.maxdemaio.strategyPattern.encapsulatedBehavior.FlyNoWay;
import com.maxdemaio.strategyPattern.encapsulatedBehavior.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        // Model duck starts off as not being able to fly
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I’m a model duck");
    }
}
