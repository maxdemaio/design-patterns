package com.maxdemaio.singletonPattern;

public class Singleton2 {
    private static Singleton2 uniqueInstance;

    private Singleton2() {}

    // Synchronized forces every thread to wait its turn
    // before it can enter the method. That is,
    // No two threads may enter the method at the same time
    // But this is very costly since we wait every time (even if already exists)
    // Could slow the application down a lot!
    public static synchronized Singleton2 getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton2();
        }
        return uniqueInstance;
    }
}
