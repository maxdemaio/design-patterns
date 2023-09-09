package com.maxdemaio.templatePattern;

// As in our design, Tea and Coffee now extend CaffeineBeverage.

public class Tea extends CaffeineBeverage {
    public void brew() {
        System.out.println("Steeping the tea");
    }

    public void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
