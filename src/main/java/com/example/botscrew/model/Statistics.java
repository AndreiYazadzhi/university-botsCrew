package com.example.botscrew.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Statistics {
    private Lecturer.Position position;
    private Long count;
}
