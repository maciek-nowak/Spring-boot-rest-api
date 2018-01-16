package com.codecool.krk.gamesapi.common;

import com.codecool.krk.gamesapi.exception.NoSuchIdException;
import com.codecool.krk.gamesapi.common.error.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchIdException.class)
    public ResponseEntity<Error> handleIfNoSuchIdExceptionOccurred() {
        Error error = new Error("no such id", "no record of such id in database");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
