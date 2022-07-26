package com.springboot.examination.payload;

import com.springboot.examination.annotation.StatusValidator;
import com.springboot.examination.annotation.CustomDateValidator;
import com.springboot.examination.model.Levels;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class ExaminationDto {
    private long exam_id;
    private String name;
    private String description;
    private String code;
    private Long levels;
    @StatusValidator()
    private String status;
    private String certificates;
    @CustomDateValidator()
    private String dateEstablished;
}
