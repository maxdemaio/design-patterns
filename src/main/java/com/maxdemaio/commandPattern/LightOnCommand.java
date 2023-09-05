package com.maxdemaio.commandPattern;


public class LightOnCommand implements Command {
    Light light;

    // passed the specific light we will control (ex: living room light)
    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
        if (!(light.getType() == null)) {
            System.out.println(light.getType() + " light is on");
        }
    }
}
