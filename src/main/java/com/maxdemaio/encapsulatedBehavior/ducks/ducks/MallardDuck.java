package com.maxdemaio.encapsulatedBehavior.ducks.ducks;

import com.maxdemaio.encapsulatedBehavior.ducks.extractBehavoir.Duck;
import com.maxdemaio.encapsulatedBehavior.ducks.extractBehavoir.FlyWithWings;
import com.maxdemaio.encapsulatedBehavior.ducks.extractBehavoir.Quack;
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
