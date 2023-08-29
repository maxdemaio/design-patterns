package com.maxdemaio.encapsulatedBehavior.ducks.extractBehavoir;

public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("Silence");
    }
}