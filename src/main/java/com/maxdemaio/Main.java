package com.maxdemaio;

import com.maxdemaio.ducks.DecoyDuck;
import com.maxdemaio.ducks.MallardDuck;
import com.maxdemaio.extractBehavoir.Duck;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello design patterns!");

        // extract behavior
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
        System.out.println();

        Duck decoy = new DecoyDuck();
        decoy.performQuack();
        decoy.performFly();
        System.out.println();

        // next thing yo
    }
}