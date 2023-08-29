package com.maxdemaio.encapsulatedBehavior.ducks.ducks;

import com.maxdemaio.encapsulatedBehavior.ducks.extractBehavoir.Duck;
import com.maxdemaio.encapsulatedBehavior.ducks.extractBehavoir.FlyNoWay;
import com.maxdemaio.encapsulatedBehavior.ducks.extractBehavoir.MuteQuack;
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
