package com.maxdemaio.strategyPattern.ducks;

import com.maxdemaio.strategyPattern.encapsulatedBehavior.FlyNoWay;
import com.maxdemaio.strategyPattern.encapsulatedBehavior.MuteQuack;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        this.quackBehavior = new MuteQuack();
        this.flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("ayo decoy");
    }
}
