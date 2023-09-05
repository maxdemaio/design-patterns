package com.maxdemaio.commandPattern;


public class LightOffCommand implements Command {
    Light light;

    // passed the specific light we will control (ex: living room light)
    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
        if (!(light.getType() == null)) {
            System.out.println(light.getType() + " light is off");
        }
    }
}
