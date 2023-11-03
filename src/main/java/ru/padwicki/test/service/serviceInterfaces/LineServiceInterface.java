package ru.padwicki.test.service.serviceInterfaces;

import org.springframework.web.bind.annotation.RequestParam;

public interface LineServiceInterface {
    String findCountOfLetters(@RequestParam String line);
}
