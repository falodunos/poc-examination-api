package com.springboot.examination.Service;

import com.springboot.examination.Model.Examination;
import com.springboot.examination.Payload.ExaminationDto;

import java.util.List;

public interface ExaminationService {
    ExaminationDto createRecord(ExaminationDto examinationDto);

    List<ExaminationDto> getAllRecords();

    ExaminationDto getRecordById(long id);

    ExaminationDto updateRecordByID(long id, ExaminationDto examinationDto);

    void deleteRecordByID(long id);
}
