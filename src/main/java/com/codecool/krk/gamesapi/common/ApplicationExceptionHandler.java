package com.codecool.krk.gamesapi.common;

import com.codecool.krk.gamesapi.exception.NoGameToUpdateException;
import com.codecool.krk.gamesapi.exception.NoSuchIdException;
import com.codecool.krk.gamesapi.common.error.Error;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
@RestController
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchIdException.class)
    public ResponseEntity<Error> handleIfNoSuchIdExceptionOccurred() {
        Error error = new Error("no such id", "no record of such id in database");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Error> handleIfConstraintViolationExceptionOccurred() {
        Error error = new Error("database constrains failed",
                "incomplite json sent by user");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Error> handleIfDataIntegrityViolationExceptionOccurred() {
        Error error = new Error("database integrity failed",
                "game belongs to database non-existent studio");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(NoGameToUpdateException.class)
    public ResponseEntity<Error> handleIfNoGameToUpdateExceptionOccurred() {
        Error error = new Error("no game to update",
                "no active game of given id in database");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
