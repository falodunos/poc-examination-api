package com.springboot.examination.Payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExaminationDto {
    private long id;
    private String name;
    private String description;
    private String code;
    private String levels;
    private String status;
    private String certificates;
    private String dateEstablished;
}
