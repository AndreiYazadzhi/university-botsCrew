package com.example.botscrew.handler.command;

import org.springframework.stereotype.Component;

@Component
public class QuitCommand implements Command {
    @Override
    public void execute(String input) {
        System.out.println("Good bye");
        System.exit(0);
    }
}
