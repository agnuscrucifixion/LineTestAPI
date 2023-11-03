package ru.padwicki.test.api.controllersInterfaces;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/line")
public interface LineControllerInterface {
    @GetMapping("/findCountOfLetters")
    String findCountOfLetters(@RequestParam @NotNull String line);
}
