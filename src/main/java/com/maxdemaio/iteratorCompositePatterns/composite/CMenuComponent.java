package com.maxdemaio.iteratorCompositePatterns.composite;

import java.util.*;

public abstract class CMenuComponent {

    public void add(CMenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public void remove(CMenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public CMenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }
    public String getDescription() {
        throw new UnsupportedOperationException();
    }
    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public abstract Iterator<CMenuComponent> createIterator();

    public void print() {
        throw new UnsupportedOperationException();
    }
}