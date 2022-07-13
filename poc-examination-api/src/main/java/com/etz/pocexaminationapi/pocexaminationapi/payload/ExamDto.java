package com.etz.pocexaminationapi.pocexaminationapi.payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExamDto {
    private long id;
    private String name;
    private String description;
    private String code;
    private String levels;
    private String status;
    private String certificates;
    private LocalDate date_established;


}
