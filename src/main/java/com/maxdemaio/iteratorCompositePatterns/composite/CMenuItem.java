package com.maxdemaio.iteratorCompositePatterns.composite;

import java.util.Iterator;

public class CMenuItem extends CMenuComponent {

    String name;
    String description;
    boolean vegetarian;
    double price;

    public CMenuItem(String name,
                     String description,
                     boolean vegetarian,
                     double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public Iterator<CMenuComponent> createIterator() {
        return new NullIterator();
    }

    public void print() {
        System.out.print("  " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println("     -- " + getDescription());
    }

}

