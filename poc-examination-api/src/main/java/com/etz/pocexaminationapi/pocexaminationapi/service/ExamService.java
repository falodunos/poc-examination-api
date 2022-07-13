package com.etz.pocexaminationapi.pocexaminationapi.service;

import com.etz.pocexaminationapi.pocexaminationapi.payload.ExamDto;

import java.util.List;

public interface ExamService {
    ExamDto createExam(ExamDto examDto);

    List<ExamDto> getAllExams();

    ExamDto getExamById(long id);

    ExamDto updateExam(ExamDto examDto, long id);

    void deleteExamById(long id);
}
