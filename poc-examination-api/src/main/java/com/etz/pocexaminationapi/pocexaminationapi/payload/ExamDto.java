package com.etz.pocexaminationapi.pocexaminationapi.payload;

import com.etz.pocexaminationapi.pocexaminationapi.annotations.CustomDateConstraint;
//import com.etz.pocexaminationapi.pocexaminationapi.annotations.LevelsIdConstraint;
//import com.etz.pocexaminationapi.pocexaminationapi.annotations.PaperIdConstraint;
import com.etz.pocexaminationapi.pocexaminationapi.annotations.PaperIdConstraint;
import com.etz.pocexaminationapi.pocexaminationapi.annotations.StatusValidator;
import com.etz.pocexaminationapi.pocexaminationapi.annotations.ToUpperCaseDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class ExamDto {
    private long id;
    private String name;
    private String description;
    private String code;
    @StatusValidator()
    @JsonDeserialize(using = ToUpperCaseDeserializer.class)
    private String status;
    private String certificates;
    @CustomDateConstraint
    private String date_established;
    @PaperIdConstraint
    private Long paper;
}
