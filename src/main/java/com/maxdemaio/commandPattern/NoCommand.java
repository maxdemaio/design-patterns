package com.maxdemaio.commandPattern;

public class NoCommand implements Command {
    public void execute() {
        System.out.println("not a command! placeholder!");
    }
}
