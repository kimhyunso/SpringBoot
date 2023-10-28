package com.example.demo.exception;


import groovy.util.ResourceException;

import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceException ex){
        ErrorResponse error = new ErrorResponse(500, "오류 테스트");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(BindValidationException.class)
    public ResponseEntity<?> handleValidationException(BindValidationException ex){
        ErrorResponse error = new ErrorResponse(400, "오류 테스트");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}