package com.example.botscrew.handler.command;

import com.example.botscrew.model.Lecturer;
import com.example.botscrew.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HeadOfDepartmentCommand implements Command {
    private final DepartmentService departmentService;

    @Override
    public void execute(String department) {
        Lecturer lecturer = departmentService.getHeadOfDepartment(department).orElseGet(null);
        if (lecturer == null) {
            System.out.println(("Department with name " + department
                    + " does not exist in DB"));
            return;
        }
        System.out.printf("Head of %s department is %s%n\n", department,
                lecturer.getFullName());
    }

}
