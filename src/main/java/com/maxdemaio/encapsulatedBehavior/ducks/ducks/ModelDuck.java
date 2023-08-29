package com.maxdemaio.encapsulatedBehavior.ducks.ducks;

import com.maxdemaio.encapsulatedBehavior.ducks.extractBehavoir.Duck;
import com.maxdemaio.encapsulatedBehavior.ducks.extractBehavoir.FlyNoWay;
import com.maxdemaio.encapsulatedBehavior.ducks.extractBehavoir.Quack;

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
