package com.maxdemaio;

import com.maxdemaio.adapterFacadePatterns.BirdAdapter;
import com.maxdemaio.adapterFacadePatterns.PlasticToyDuck;
import com.maxdemaio.adapterFacadePatterns.Sparrow;
import com.maxdemaio.adapterFacadePatterns.ToyDuck;
import com.maxdemaio.commandPattern.*;
import com.maxdemaio.decoratorPattern.*;
import com.maxdemaio.factoryPattern.creators.ChicagoPizzaStore;
import com.maxdemaio.factoryPattern.creators.NYPizzaStore;
import com.maxdemaio.factoryPattern.products.Pizza;
import com.maxdemaio.factoryPattern.creators.PizzaStore;
import com.maxdemaio.iteratorCompositePatterns.pureIterator.DinerMenu;
import com.maxdemaio.iteratorCompositePatterns.pureIterator.PancakeHouseMenu;
import com.maxdemaio.iteratorCompositePatterns.pureIterator.Waitress;
import com.maxdemaio.observerPattern.CurrentConditionsDisplay;
import com.maxdemaio.observerPattern.HeatIndexConditionsDisplay;
import com.maxdemaio.observerPattern.WeatherData;
import com.maxdemaio.proxyPattern.ImageProxyTestDrive;
import com.maxdemaio.singletonPattern.Singleton4;
import com.maxdemaio.statePattern.GumballMachine;
import com.maxdemaio.strategyPattern.ducks.*;
import com.maxdemaio.strategyPattern.encapsulatedBehavior.FlyWithWings;
import com.maxdemaio.templatePattern.CaffeineBeverage;
import com.maxdemaio.templatePattern.Coffee;
import com.maxdemaio.templatePattern.Tea;

public class Main {
    public static void main(String[] args) throws Exception {
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

        // Setup macro
        Command[] allOn = {livingRoomLightOn, kitchenLightOn};
        Command[] allOff = {livingRoomLightOff, livingRoomLightOff};

        MacroCommand partyOnMacro = new MacroCommand(allOn);
        MacroCommand partyOffMacro = new MacroCommand(allOff);
        newerRemoteControl.setCommand(2, partyOnMacro, partyOffMacro);
        System.out.println(newerRemoteControl);
        System.out.println("--- Pushing Macro On---");
        newerRemoteControl.onButtonWasPushed(0);
        System.out.println("--- Pushing Macro Off---");
        newerRemoteControl.offButtonWasPushed(0);
        System.out.println("---------------------------");
        System.out.println();


        // ** Chapter 7 ** //
        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        // Wrap a bird in a birdAdapter so that it
        // behaves like toy duck
        ToyDuck birdAdapter = new BirdAdapter(sparrow);

        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("ToyDuck...");
        toyDuck.squeak();

        // toy duck behaving like a bird
        System.out.println("BirdAdapter...");
        birdAdapter.squeak();

        // A facade not only simplifies an interface, it decouples a client
        // from a subsystem of components.
        // Facades and adapters may wrap multiple
        // classes, but a facade’s intent is to simplify, while
        // an adapter’s is to convert the interface to something different.
        System.out.println("---------------------------");
        System.out.println();

        // ** Chapter 8 **//
        /**
         * The Template Method defines the steps of an algorithm
         * and allows subclasses to provide the implementation for one or more steps.
         */
        CaffeineBeverage coffee = new Coffee();
        CaffeineBeverage tea = new Tea();
        coffee.prepareRecipe();
        tea.prepareRecipe();
        System.out.println("---------------------------");
        System.out.println();

        // ** Chapter 9 **//
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
        System.out.println("---------------------------");
        System.out.println();

        // ** Chapter 10 ** //
        GumballMachine gumballMachine = new GumballMachine(2);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.refill(5);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
        System.out.println("---------------------------");
        System.out.println();

        // ** Chapter 10 ** //
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();

    }

}





