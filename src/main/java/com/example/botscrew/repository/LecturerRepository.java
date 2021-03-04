package com.example.botscrew.repository;

import com.example.botscrew.model.Lecturer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    List<Lecturer> getAllByFullNameIsContaining(String pattern);
}
