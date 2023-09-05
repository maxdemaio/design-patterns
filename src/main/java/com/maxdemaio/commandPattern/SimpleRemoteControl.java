package com.maxdemaio.commandPattern;

public class SimpleRemoteControl {

    // one slot to hold our command which controls 1 device
    Command slot;

    public SimpleRemoteControl() {}

    // setting command the slot will control
    // can be called multiple times if we wanted to change the behavior
    public void setCommand(Command command) {
        slot = command;
    }

    // take the current command bound to the
    public void buttonWasPressed() {
        slot.execute();
    }
}
