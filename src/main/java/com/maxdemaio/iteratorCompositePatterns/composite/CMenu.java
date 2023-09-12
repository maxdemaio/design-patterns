package com.maxdemaio.iteratorCompositePatterns.composite;


import java.util.ArrayList;
import java.util.Iterator;

public class CMenu extends CMenuComponent {
    Iterator<CMenuComponent> iterator = null;
    ArrayList<CMenuComponent> menuComponents = new ArrayList<CMenuComponent>();
    String name;
    String description;

    public CMenu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(CMenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(CMenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public CMenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public Iterator<CMenuComponent> createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }


    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        Iterator<CMenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            CMenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }
    }
}

