package ru.padwicki.test.service.serviceInterfaces;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.RequestParam;

public interface LineServiceInterface {
    String findCountOfLetters(@RequestParam @NotNull String line);
}
