package com.maxdemaio;

import com.maxdemaio.commandPattern.*;
import com.maxdemaio.decoratorPattern.*;
import com.maxdemaio.factoryPattern.creators.ChicagoPizzaStore;
import com.maxdemaio.factoryPattern.creators.NYPizzaStore;
import com.maxdemaio.factoryPattern.products.Pizza;
import com.maxdemaio.factoryPattern.creators.PizzaStore;
import com.maxdemaio.observerPattern.CurrentConditionsDisplay;
import com.maxdemaio.observerPattern.HeatIndexConditionsDisplay;
import com.maxdemaio.observerPattern.WeatherData;
import com.maxdemaio.singletonPattern.Singleton4;
import com.maxdemaio.strategyPattern.ducks.DecoyDuck;
import com.maxdemaio.strategyPattern.ducks.MallardDuck;
import com.maxdemaio.strategyPattern.ducks.ModelDuck;
import com.maxdemaio.strategyPattern.ducks.Duck;
import com.maxdemaio.strategyPattern.encapsulatedBehavior.FlyWithWings;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello design patterns!");

        // ** Chapter 1 Strategy ** //
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


        // ** Chapter 2 Observer ** //
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

        // ** Chapter 3 Decorator **//
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2); // Wrap the house blend w/ mocha
        beverage2 = new Mocha(beverage2); // Wrap the house blend w/ 2nd mocha
        beverage2 = new Whip(beverage2); // Add whip cream
        // House blend, double mocha w/ whipped cream!
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
        System.out.println("---------------------------");
        System.out.println();

        // ** Chapter 4 Factory **//
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
        System.out.println("---------------------------");
        System.out.println();

        // ** Chapter 5 Singleton ** //
        System.out.println("Singleton");
        Singleton4 mySingleton = Singleton4.getInstance();
        System.out.println("---------------------------");
        System.out.println();

        // ** Chapter 6 **//
        // remote is the invoker, passed command object to make requests
        SimpleRemoteControl remote = new SimpleRemoteControl();
        // Now we create a Light object which is the receiver of the request
        Light light = new Light();
        // create a command and pass the receiver to it
        LightOnCommand lightOn = new LightOnCommand(light);
        // pass command to the invoker
        remote.setCommand(lightOn);
        // simulate button being pressed
        remote.buttonWasPressed();

        RemoteControl newerRemoteControl = new RemoteControl();

        // Create devices
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // Create commands
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        // Load commands into remote slots
        newerRemoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        newerRemoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        System.out.println(newerRemoteControl);

        newerRemoteControl.onButtonWasPushed(0);
        newerRemoteControl.offButtonWasPushed(0);
        newerRemoteControl.onButtonWasPushed(1);
        newerRemoteControl.offButtonWasPushed(1);
    }
}