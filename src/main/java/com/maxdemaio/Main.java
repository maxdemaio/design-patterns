package com.maxdemaio;

import com.maxdemaio.ducks.DecoyDuck;
import com.maxdemaio.ducks.MallardDuck;
import com.maxdemaio.ducks.ModelDuck;
import com.maxdemaio.extractBehavoir.Duck;
import com.maxdemaio.extractBehavoir.FlyWithWings;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello design patterns!");

        // ** Chapter 1 ** //
        // extract behavior
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();
        mallard.performFly();
        System.out.println();

        Duck decoy = new DecoyDuck();
        decoy.display();
        decoy.performQuack();
        decoy.performFly();
        System.out.println();

        // Setting behavior dynamically
        Duck model = new ModelDuck(); // starts off as can't fly
        model.display();
        model.performFly();
        model.setFlyBehavior(new FlyWithWings());
        model.performFly();
        System.out.println();
    }
}