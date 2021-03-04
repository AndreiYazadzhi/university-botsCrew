package com.example.botscrew.service.impl;

import com.example.botscrew.model.Lecturer;
import com.example.botscrew.repository.LecturerRepository;
import com.example.botscrew.service.LecturerService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LecturerServiceImpl implements LecturerService {
    private final LecturerRepository repository;

    @Override
    public void save(Lecturer lecturer) {
        repository.save(lecturer);
    }

    @Override
    public List<Lecturer> getAllByFullNameIsContaining(String pattern) {
        return repository.getAllByFullNameIsContaining(pattern);
    }
}
