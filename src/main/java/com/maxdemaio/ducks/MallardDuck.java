package com.maxdemaio.ducks;

import com.maxdemaio.extractBehavoir.*;

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
