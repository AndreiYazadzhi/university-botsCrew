package com.example.botscrew.handler.command;

import com.example.botscrew.model.Statistics;
import com.example.botscrew.service.DepartmentService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShowStatisticCommand implements Command {
    private final DepartmentService departmentService;

    @Override
    public void execute(String department) {
        List<Statistics> statistics = departmentService.countByPosition(department);
        for (Statistics details : statistics) {
            System.out.println(details.getPosition().name().toLowerCase()
                    + " - " + details.getCount());
        }
    }
}
