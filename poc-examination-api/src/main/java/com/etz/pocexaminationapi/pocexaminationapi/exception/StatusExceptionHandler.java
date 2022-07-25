package com.etz.pocexaminationapi.pocexaminationapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class StatusExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<List> processUnmergedException(final MethodArgumentNotValidException ex) {

        List list = ex.getBindingResult().getAllErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }
}
