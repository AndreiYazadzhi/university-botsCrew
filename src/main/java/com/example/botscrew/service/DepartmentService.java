package com.example.botscrew.service;

import com.example.botscrew.model.Department;
import com.example.botscrew.model.Lecturer;
import com.example.botscrew.model.Statistics;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    void save(Department department);

    Double getAverageSalaryByDepartment(String department);

    Integer countAllLecturersByDepartment(String department);

    Optional<Lecturer> getHeadOfDepartment(String department);

    List<Statistics> countByPosition(String department);
}
