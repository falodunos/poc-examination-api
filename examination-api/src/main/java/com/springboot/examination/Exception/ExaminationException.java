package com.springboot.examination.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExaminationException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public ExaminationException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ExaminationException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
