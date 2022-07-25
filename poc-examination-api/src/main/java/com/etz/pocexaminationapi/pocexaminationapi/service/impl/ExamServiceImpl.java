package com.etz.pocexaminationapi.pocexaminationapi.service.impl;

import com.etz.pocexaminationapi.pocexaminationapi.exception.ResourceNotFoundException;
import com.etz.pocexaminationapi.pocexaminationapi.model.Exam;
import com.etz.pocexaminationapi.pocexaminationapi.payload.ExamDto;
import com.etz.pocexaminationapi.pocexaminationapi.repository.ExamRepository;
import com.etz.pocexaminationapi.pocexaminationapi.repository.PaperRepository;
import com.etz.pocexaminationapi.pocexaminationapi.service.ExamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {

    private ExamRepository examRepository;
    private PaperRepository paperRepository;

    public ExamServiceImpl(ExamRepository examRepository, PaperRepository paperRepository) {
        this.examRepository = examRepository;
        this.paperRepository = paperRepository;
    }

    @Override
    public ExamDto createExam(ExamDto examDto) {

        // convert Dto to entity
        Exam exam = mapToEntity(examDto);
        Exam newExam = examRepository.save(exam);

        // convert entity to Dto
        ExamDto examResponse = mapToDTO(newExam);

        return examResponse;
    }

    @Override
    public List<ExamDto> getAllExams() {
        List<Exam> exams = examRepository.findAll();
        return exams.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }

    @Override
    public ExamDto getExamById(long id) {
        Exam exam = examRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exam", "id", id));
        return mapToDTO(exam);
    }

    @Override
    public ExamDto updateExam(ExamDto examDto, long id) {
        //get post by id from the database
        Exam exam = examRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exam", "id", id));

        exam.setName(examDto.getName());
        exam.setDescription(examDto.getDescription());
        exam.setCode(examDto.getCode());
        exam.setPaper(paperRepository.getReferenceById((examDto.getPaper())));
        exam.setStatus(examDto.getStatus());
        exam.setCertificates(examDto.getCertificates());
        exam.setDate_established(examDto.getDate_established());

        Exam updatedExam = examRepository.save(exam);
        return mapToDTO(updatedExam);
    }

    @Override
    public void deleteExamById(long id) {
        //get post by id from the database
        Exam exam = examRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exam", "id", id));
        examRepository.delete(exam);
    }

    //convert Entity to DTO
    private ExamDto mapToDTO(Exam exam){
        ExamDto examDto = new ExamDto();
        examDto.setId(exam.getId());
        examDto.setName(exam.getName());
        examDto.setDescription(exam.getDescription());
        examDto.setCode(exam.getCode());
        examDto.setPaper((exam.getPaper().getId()));
        examDto.setStatus(exam.getStatus());
        examDto.setCertificates(exam.getCertificates());
        examDto.setDate_established(exam.getDate_established());
        return examDto;
    }

    // convert DTO to entity
    private Exam mapToEntity(ExamDto examDto) {
        Exam exam = new Exam();
        exam.setName(examDto.getName());
        exam.setDescription(examDto.getDescription());
        exam.setCode(examDto.getCode());
        exam.setPaper(paperRepository.getReferenceById(examDto.getPaper()));
        exam.setStatus(examDto.getStatus());
        exam.setCertificates(examDto.getCertificates());
        exam.setDate_established(examDto.getDate_established());
        return exam;
    }
}
