package ru.padwicki.test.service.exceptions.advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.padwicki.test.service.exceptions.customExceptions.ErrorResponse;
import ru.padwicki.test.service.exceptions.customExceptions.IncorrectStringLineException;
import ru.padwicki.test.service.exceptions.customExceptions.TooBigLineException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class AdviceException {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleException(NoSuchElementException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(IncorrectStringLineException.class)
    public ResponseEntity<ErrorResponse> handleException() {
        ErrorResponse response = new ErrorResponse("Wrong string line");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TooBigLineException.class)
    public ResponseEntity<ErrorResponse> handleException(TooBigLineException e) {
        ErrorResponse response = new ErrorResponse("Too beg string line");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
