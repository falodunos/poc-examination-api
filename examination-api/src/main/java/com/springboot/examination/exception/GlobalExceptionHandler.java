package com.springboot.examination.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {ExaminationException.class})
    public ResponseEntity<String> handleNoId(ExaminationException e) {
        return new ResponseEntity<String>("Id does not exist", HttpStatus.NOT_FOUND);
    }
}
