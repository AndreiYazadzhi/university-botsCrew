package com.example.botscrew.service;

import com.example.botscrew.model.Lecturer;
import java.util.List;

public interface LecturerService {
    void save(Lecturer lecturer);

    List<Lecturer> getAllByFullNameIsContaining(String pattern);
}
