package com.maxdemaio.singletonPattern;

public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {}

    // Has problems with multi-threading
    // Two objects could be created!
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
