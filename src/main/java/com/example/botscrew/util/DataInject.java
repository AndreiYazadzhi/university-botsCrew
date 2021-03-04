package com.example.botscrew.util;

import com.example.botscrew.model.Department;
import com.example.botscrew.model.Lecturer;
import com.example.botscrew.service.DepartmentService;
import com.example.botscrew.service.LecturerService;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInject {
    private final DepartmentService departmentService;
    private final LecturerService lecturerService;

    @PostConstruct
    public void init() {
        Lecturer bob = new Lecturer();
        bob.setPosition(Lecturer.Position.ASSISTANT);
        bob.setFullName("Bob Johnson");

        bob.setSalary(15000.00);
        lecturerService.save(bob);
        Lecturer john = new Lecturer();
        john.setPosition(Lecturer.Position.ASSOCIATE_PROFESSOR);
        john.setFullName("John Bobson");

        john.setSalary(20000.00);
        lecturerService.save(john);
        Lecturer alice = new Lecturer();
        alice.setPosition(Lecturer.Position.PROFESSOR);
        alice.setFullName("Alice Johnson");
        alice.setSalary(25000.00);
        lecturerService.save(alice);
        Department physical = new Department();
        physical.setLecturers(List.of(bob, john, alice));
        physical.setHead(alice);
        physical.setName("Physical");
        departmentService.save(physical);
    }
}

