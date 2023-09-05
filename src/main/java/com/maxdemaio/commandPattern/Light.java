package com.maxdemaio.commandPattern;

public class Light {
    String type;

    public Light(String type) {
        this.type = type;
    }

    public Light() {}
    public void on() {
        System.out.println("light on!");
    }
    public void off() {
        System.out.println("light off!");
    }

    public String getType() {
        return type;
    }
}
