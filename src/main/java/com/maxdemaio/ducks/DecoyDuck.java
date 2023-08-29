package com.maxdemaio.ducks;

import com.maxdemaio.extractBehavoir.*;

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
