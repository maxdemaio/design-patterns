package com.maxdemaio.iteratorCompositePatterns.composite;

import java.util.Iterator;
import java.util.Stack;


public class CompositeIterator implements Iterator<CMenuComponent> {
    Stack<Iterator<CMenuComponent>> stack = new Stack<Iterator<CMenuComponent>>();

    public CompositeIterator(Iterator<CMenuComponent> iterator) {
        stack.push(iterator);
    }

    public CMenuComponent next() {
        if (hasNext()) {
            Iterator<CMenuComponent> iterator = stack.peek();
            CMenuComponent component = iterator.next();
            stack.push(component.createIterator());
            return component;
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator<CMenuComponent> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

	/*
	 * No longer needed as of Java 8
	 *
	 * (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 *
	public void remove() {
		throw new UnsupportedOperationException();
	}
	*/
}

