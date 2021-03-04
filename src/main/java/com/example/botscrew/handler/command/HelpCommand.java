package com.example.botscrew.handler.command;

import org.springframework.stereotype.Component;

@Component
public class HelpCommand implements Command {
    @Override
    public void execute(String input) {
        String help = "'help' - for more details about command \n"
                + "'Who is head of department {department_name}'\n"
                + "'Show {department_name} statistics'\n"
                + "'Show the average salary for the department {department_name}'\n"
                + "'Show count of employee for {department_name}'\n"
                + "'Global search by {template}'\n"
                + "'q' - for exit";
        System.out.println(help);
    }
}
