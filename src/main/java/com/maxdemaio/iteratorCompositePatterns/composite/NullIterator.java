package com.maxdemaio.iteratorCompositePatterns.composite;

import java.util.Iterator;

/**
 * We can still return an iterator,
 * Return an iterator that always returns false when hasNext() is called.
 * The client doesn’t have to worry about whether or not null is ever returned.
 * In effect, we’re creating an iterator that is a “no op”.
 */
public class NullIterator implements Iterator {
    public Object next() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
