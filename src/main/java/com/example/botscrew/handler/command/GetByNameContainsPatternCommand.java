package com.example.botscrew.handler.command;

import com.example.botscrew.service.LecturerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetByNameContainsPatternCommand implements Command {
    private final LecturerService lecturerService;

    @Override
    public void execute(String pattern) {
        System.out.println(lecturerService.getAllByFullNameIsContaining(pattern));
    }
}
