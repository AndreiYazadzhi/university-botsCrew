package com.example.botscrew;

import com.example.botscrew.handler.ConsoleHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotsCrewApplication {

    public static void main(String[] args) {
        new ConsoleHandler(SpringApplication.run(BotsCrewApplication.class, args)).handle();
    }
}
