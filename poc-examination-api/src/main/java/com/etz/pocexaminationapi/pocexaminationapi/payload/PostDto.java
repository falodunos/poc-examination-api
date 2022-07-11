package com.etz.pocexaminationapi.pocexaminationapi.payload;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PostDto {
    private long id;
    private String name;
    private String description;
    private String code;
    private String levels;
    private String status;
    private String certificates;
    private LocalDate date_established;


}
