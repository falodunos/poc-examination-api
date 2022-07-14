package com.springboot.examination.service;

import com.springboot.examination.payload.ExaminationDto;

import java.util.List;

public interface ExaminationService {
    ExaminationDto createRecord(ExaminationDto examinationDto);

    List<ExaminationDto> getAllRecords();

    ExaminationDto getRecordById(long id);

    ExaminationDto updateRecordByID(long id, ExaminationDto examinationDto);

    void deleteRecordByID(long id);
}
