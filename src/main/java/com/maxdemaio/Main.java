package com.maxdemaio;

import com.maxdemaio.decoratorPattern.*;
import com.maxdemaio.observerPattern.CurrentConditionsDisplay;
import com.maxdemaio.observerPattern.HeatIndexConditionsDisplay;
import com.maxdemaio.observerPattern.WeatherData;
import com.maxdemaio.strategyPattern.ducks.DecoyDuck;
import com.maxdemaio.strategyPattern.ducks.MallardDuck;
import com.maxdemaio.strategyPattern.ducks.ModelDuck;
import com.maxdemaio.strategyPattern.ducks.Duck;
import com.maxdemaio.strategyPattern.encapsulatedBehavior.FlyWithWings;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello design patterns!");

        // ** Chapter 1 ** //
        System.out.println("Chapter 1, Strategy Pattern");
        System.out.println("---------------------------");
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
        System.out.println("---------------------------");
        System.out.println();


        // ** Chapter 2 ** //
        System.out.println("Chapter 1, Observer Pattern");
        System.out.println("---------------------------");
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        HeatIndexConditionsDisplay heatIndexConditionsDisplay = new HeatIndexConditionsDisplay(weatherData);
        weatherData.setMeasurements(68, 20, 33.2f);
        System.out.println();

        // ** Chapter 3 **//
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2); // Wrap the house blend w/ mocha
        beverage2 = new Mocha(beverage2); // Wrap the house blend w/ 2nd mocha
        beverage2 = new Whip(beverage2); // Add whip cream
        // House blend, double mocha w/ whipped cream!
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}