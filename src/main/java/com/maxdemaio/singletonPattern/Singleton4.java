package com.maxdemaio.singletonPattern;

public class Singleton4 {
    // volatile keyword ensures that multiple threads
    // handle the uniqueInstance variable correctly
    // When it's being initialized to the singleton instance
    // double-checked locking (check if created, if not, then we synchronize)
    // this way we synchronize the first time like we want
    private volatile static Singleton4 uniqueInstance;

    private Singleton4() {}

    // Synchronized forces every thread to wait its turn
    // before it can enter the method. That is,
    // No two threads may enter the method at the same time
    // But this is very costly since we wait every time (even if already exists)
    // Could slow the application down a lot!
    public static synchronized Singleton4 getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton4();
        }
        return uniqueInstance;
    }
}
