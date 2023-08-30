package com.maxdemaio.strategyPattern.ducks;

import com.maxdemaio.strategyPattern.encapsulatedBehavior.FlyWithWings;
import com.maxdemaio.strategyPattern.encapsulatedBehavior.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        this.quackBehavior = new Quack();
        this.flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("ayo mallard");
    }
}
