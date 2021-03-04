package com.example.botscrew.service.impl;

import com.example.botscrew.model.Department;
import com.example.botscrew.model.Lecturer;
import com.example.botscrew.model.Statistics;
import com.example.botscrew.repository.DepartmentRepository;
import com.example.botscrew.service.DepartmentService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    @Override
    public void save(Department department) {
        repository.save(department);
    }

    @Override
    public Double getAverageSalaryByDepartment(String department) {
        return repository.getAverageSalaryByDepartment(department);
    }

    @Override
    public Integer countAllLecturersByDepartment(String department) {
        return repository.countAllLecturersByDepartment(department);
    }

    @Override
    public Optional<Lecturer> getHeadOfDepartment(String department) {
        return repository.getHeadOfDepartment(department);
    }

    @Override
    public List<Statistics> countByPosition(String department) {
        return repository.countByPosition(department);
    }
}
