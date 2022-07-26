package com.springboot.examination.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {ExaminationException.class})
    public ResponseEntity<String> handleNoId(ExaminationException e) {
        return new ResponseEntity<String>("Id does not exist", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List> statusException(final MethodArgumentNotValidException ex) {
        List list = ex.getBindingResult().getAllErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(value = ExaminationException.class)
//    public ResponseEntity<String> handleStatus(ExaminationException e) {
//        return new ResponseEntity<String>("Examination status can only be ACTIVE/INACTIVE", HttpStatus.BAD_REQUEST);
//    }
}

























//@ResponseStatus(value = HTTPStatus.NOT_FOUND)
//extends RuntimeException
//
//private HTTPStatus httpStatus;
//private String message;
//
//create constructor
//create constructor with super
//create getters
//
//
//@ControllerAdvice
//method declaration
//ExceptionHandler(value = {ExaminaionException.class})
//declare the various exception handlers

