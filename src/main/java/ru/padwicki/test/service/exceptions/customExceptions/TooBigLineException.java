package ru.padwicki.test.service.exceptions.customExceptions;

public class TooBigLineException extends RuntimeException{

    public TooBigLineException(String message) {
        super(message);
    }
    public TooBigLineException() {
        super();
    }
}
