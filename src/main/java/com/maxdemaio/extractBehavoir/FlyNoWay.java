package com.maxdemaio.extractBehavoir;

// Ducks that can't fly like rubber/decoy ducks
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can't fly!");
    }
}
