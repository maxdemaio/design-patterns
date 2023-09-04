package com.maxdemaio.singletonPattern;

public class Singleton3 {
    // Eagerly create instance of Singleton
    // guaranteed to be thread safe
    private static Singleton3 uniqueInstance = new Singleton3();

    private Singleton3() {}

    // We've already created an instance, so just return it
    public static synchronized Singleton3 getInstance() {
        return uniqueInstance;
    }
}
