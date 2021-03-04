package com.example.botscrew;

import com.example.botscrew.model.Lecturer;
import com.example.botscrew.model.Statistics;
import com.example.botscrew.service.DepartmentService;
import com.example.botscrew.service.LecturerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BotsCrewApplicationTests {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private LecturerService lecturerService;
    private static final String DEPARTMENT_NAME = "Physical";

    @Test
    public void contextLoads() {
    }

    @Test
    public void getAverageSalaryByDepartment_Ok() {
        Double expected = 20000.00;
        Double actual = departmentService.getAverageSalaryByDepartment(DEPARTMENT_NAME);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAverageSalaryByDepartment_NotOk() {
        Assertions.assertNull(departmentService.getAverageSalaryByDepartment("Incorrect name"));
    }

    @Test
    public void countLecturersByDepartment_Ok() {
        Integer expected = 3;
        Integer actual = departmentService.countAllLecturersByDepartment(DEPARTMENT_NAME);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void countLecturersByDepartment_NotOk() {
        Assertions.assertNull(departmentService.countAllLecturersByDepartment("Incorrect name"));
    }

    @Test
    public void getHeadOfDepartment_Ok() {
        Assertions.assertNotNull(departmentService.getHeadOfDepartment(DEPARTMENT_NAME));
    }

    @Test
    public void getHeadOfDepartment_NotOk() {
        Assertions.assertEquals(departmentService.getHeadOfDepartment("Incorrect name"),
                Optional.empty());
    }

    @Test
    public void countByPosition_Ok() {
        List<Statistics> expected = new ArrayList<>();
        expected.add(new Statistics(Lecturer.Position.ASSISTANT, 1L));
        expected.add(new Statistics(Lecturer.Position.ASSOCIATE_PROFESSOR, 1L));
        expected.add(new Statistics(Lecturer.Position.PROFESSOR, 1L));
        List<Statistics> actual = departmentService.countByPosition(DEPARTMENT_NAME);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void countByPosition_NotOk() {
        List<Statistics> expected = new ArrayList<>();
        List<Statistics> actual = departmentService.countByPosition("Incorrect name");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllByFullNameContainingPattern_NotOk() {
        List<Lecturer> expected = new ArrayList<>();
        List<Lecturer> actual = lecturerService.getAllByFullNameIsContaining("Incorrect");
        Assertions.assertEquals(expected, actual);
    }
}
