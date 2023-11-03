package ru.padwicki.test.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.padwicki.test.api.controllersInterfaces.LineControllerInterface;
import ru.padwicki.test.service.serviceImpl.LineService;

@RestController
public class LineController implements LineControllerInterface {
    private final LineService lineService;
    @Autowired
    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @Override
    public String findCountOfLetters(String line) {
        return lineService.findCountOfLetters(line);
    }
}
