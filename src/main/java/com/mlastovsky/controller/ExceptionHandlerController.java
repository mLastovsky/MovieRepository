package com.mlastovsky.controller;

import com.mlastovsky.exception.DirectorNotFoundException;
import com.mlastovsky.exception.MovieNotFoundException;
import com.mlastovsky.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorDetails> movieNotFoundException(MovieNotFoundException e) {
        var errorDetails = new ErrorDetails(
                "Movie Not Found"
        );
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler(DirectorNotFoundException.class)
    public ResponseEntity<ErrorDetails> directorNotFoundException(MovieNotFoundException e) {
        var errorDetails = new ErrorDetails(
                "Director Not Found"
        );
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
