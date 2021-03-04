package com.example.botscrew.handler.command;

import com.example.botscrew.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetAvgSalaryByDepartmentCommand implements Command {
    private final DepartmentService departmentService;

    @Override
    public void execute(String department) {
        System.out.printf("The average salary of %s is %.2f\n", department,
                departmentService.getAverageSalaryByDepartment(department));
    }
}
