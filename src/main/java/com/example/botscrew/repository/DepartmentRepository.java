package com.example.botscrew.repository;

import com.example.botscrew.model.Department;
import com.example.botscrew.model.Lecturer;
import com.example.botscrew.model.Statistics;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(value = "SELECT AVG(l.salary) FROM Department d JOIN d.lecturers l WHERE d.name = ?1")
    Double getAverageSalaryByDepartment(String department);

    @Query(value = "SELECT new com.example.botscrew.model.Statistics(l.position, COUNT(l))"
            + " FROM Department d JOIN d.lecturers l WHERE d.name = ?1 GROUP BY d, l.position")
    List<Statistics> countByPosition(String department);

    @Query(value = "SELECT d.lecturers.size FROM Department d WHERE d.name = ?1")
    Integer countAllLecturersByDepartment(String department);

    @Query(value = "SELECT d.head FROM Department d WHERE d.name = ?1")
    Optional<Lecturer> getHeadOfDepartment(String department);
}
