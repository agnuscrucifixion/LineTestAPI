package ru.padwicki.test.service.exceptions.customExceptions;

public class IncorrectStringLineException extends RuntimeException{

    public IncorrectStringLineException(String message) {
        super(message);
    }
}
