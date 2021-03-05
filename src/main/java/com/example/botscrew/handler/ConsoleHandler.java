package com.example.botscrew.handler;

import com.example.botscrew.handler.command.Command;
import com.example.botscrew.handler.command.GetAvgSalaryByDepartmentCommand;
import com.example.botscrew.handler.command.GetByNameContainsPatternCommand;
import com.example.botscrew.handler.command.GetCountOfLecturersCommand;
import com.example.botscrew.handler.command.HeadOfDepartmentCommand;
import com.example.botscrew.handler.command.QuitCommand;
import com.example.botscrew.handler.command.ShowStatisticCommand;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ConsoleHandler {
    private final Map<String, Command> handler = new HashMap<>();

    public ConsoleHandler(ApplicationContext applicationContext) {
        handler.put("1 ([\\w ]+)",
                applicationContext.getBean(HeadOfDepartmentCommand.class));

        handler.put("2 ([\\w ]+)",
                applicationContext.getBean(ShowStatisticCommand.class));

        handler.put("3 ([\\w ]+)",
                applicationContext.getBean(GetAvgSalaryByDepartmentCommand.class));

        handler.put("4 ([\\w ]+)",
                applicationContext.getBean(GetCountOfLecturersCommand.class));

        handler.put("5 ([\\w ]+)",
                applicationContext.getBean(GetByNameContainsPatternCommand.class));

        handler.put("(exit) |q|", applicationContext.getBean(QuitCommand.class));
    }

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect = false;
        String help = "'Type command number and enter value after whitespace\n"
                + "'1 Who is head of department {department_name}'\n"
                + "'2 Show {department_name} statistics'\n"
                + "'3 Show the average salary for the department {department_name}'\n"
                + "'4 Show count of employee for {department_name}'\n"
                + "'5 Global search by {template}'\n"
                + "'q' - for exit";
        System.out.println(help);
        while (true) {
            String input = scanner.nextLine();
            for (Map.Entry<String, Command> action : handler.entrySet()) {
                if (input.matches(action.getKey())) {
                    action.getValue()
                            .execute(input.replaceAll(action.getKey(), "$1"));
                    isCorrect = true;
                    break;
                }
            }
            if (!isCorrect) {
                System.out.println("Incorrect command!");
            }
            isCorrect = false;
        }
    }
}
