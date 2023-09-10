package com.maxdemaio.iteratorCompositePatterns;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu {
    ArrayList menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList();
        addItem("K & B’s Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast", true,
                2.99);
        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage", false,
                2.99);
        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries", true,
                3.49);
        addItem("Waffles",

                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    /**
     * We’re not going to need the getMenuItems() method anymore and in fact,
     * we don’t want it because it exposes our internal implementation!
     */
//    public ArrayList getMenuItems() {
//        return menuItems;
//    }

    public Iterator createIterator() {
        return menuItems.iterator();
    }
}