package com.practice.SpringBootBackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.practice.SpringBootBackend.exceptions.InvalidRequestBodyException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }

    @ExceptionHandler(InvalidRequestBodyException.class)
    public ResponseEntity<String> handleInvalidRequestException(InvalidRequestBodyException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
