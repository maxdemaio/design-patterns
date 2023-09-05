package com.maxdemaio.commandPattern;

public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] commands) {
        //Take an array of Commands and store them in the MacroCommand.
        this.commands = commands;
    }

    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            // When the macro gets executed by the remote, execute those commands one at a time.
            commands[i].execute();
        }
    }
}
