package com.springboot.examination.service.Impl;

import com.springboot.examination.exception.ExaminationException;
import com.springboot.examination.model.Examination;
import com.springboot.examination.payload.ExaminationDto;
import com.springboot.examination.repository.ExaminationRepository;
import com.springboot.examination.repository.LevelsRepository;
import com.springboot.examination.service.ExaminationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExaminationServiceImpl implements ExaminationService {
    private ExaminationRepository examinationRepository;
    private LevelsRepository levelsRepository;

    public ExaminationServiceImpl(ExaminationRepository examinationRepository, LevelsRepository levelsRepository) {
        this.examinationRepository = examinationRepository;
        this.levelsRepository = levelsRepository;
    }

    @Override
    public ExaminationDto createRecord(ExaminationDto examinationDto) {
        //      convert client dto to entity
        Examination examination = mapToEntity(examinationDto);
        ExaminationDto response = new ExaminationDto();
        if (examination.getStatus().equals("ACTIVE")) {
            //      save to repository
            Examination newPost = examinationRepository.save(examination);
            //      convert entity to dto
            response = mapToDto(newPost);
        }
        else if (examination.getStatus().equals("INACTIVE")) {
            //      save to repository
            Examination newPost = examinationRepository.save(examination);
            //      convert entity to dto
            response = mapToDto(newPost);
        }
        return response;
    }

    @Override
    public List<ExaminationDto> getAllRecords() {
        List<Examination> posts = examinationRepository.findAll();
        return posts.stream().map(examination -> mapToDto(examination)).collect(Collectors.toList());
    }

    @Override
    public ExaminationDto getRecordById(long id) {
        Examination examination = examinationRepository.findById(id).orElseThrow(() -> new ExaminationException(HttpStatus.NOT_FOUND, "Id does not exist"));
        return mapToDto(examination);
    }

    @Override
    public ExaminationDto updateRecordByID(long id, ExaminationDto examinationDto) {
        Examination examination = examinationRepository.findById(id).orElseThrow(() -> new ExaminationException(HttpStatus.NOT_FOUND, "Id does not exist"));

        examination.setName(examination.getName());
        examination.setDescription(examinationDto.getDescription());
        examination.setCode(examination.getCode());
        examination.setLevels(levelsRepository.getReferenceById(examinationDto.getLevels()));
        examination.setStatus(examinationDto.getStatus());
        examination.setCertificates(examinationDto.getCertificates());
        examination.setDateEstablished(examinationDto.getDateEstablished());

        Examination updatedPost = examinationRepository.save(examination);

        return mapToDto(updatedPost);
    }

    @Override
    public void deleteRecordByID(long id) {
        Examination examination = examinationRepository.findById(id).orElseThrow(() -> new ExaminationException(HttpStatus.BAD_REQUEST, "Id does not exist"));
        examinationRepository.delete(examination);
    }

    //  convert from dto to entity
    private Examination mapToEntity(ExaminationDto examinationDto) {
        Examination examination = new Examination();
        examination.setExam_id(examinationDto.getExam_id());
        examination.setName(examinationDto.getName());
        examination.setDescription(examinationDto.getDescription());
        examination.setCode(examinationDto.getCode());
        examination.setLevels(levelsRepository.getReferenceById(examinationDto.getLevels()));
        examination.setStatus(examinationDto.getStatus());
        examination.setCertificates(examinationDto.getCertificates());
        examination.setDateEstablished(examinationDto.getDateEstablished());

        return examination;
    }

//  convert from entity to dto
    private ExaminationDto mapToDto(Examination examination) {
        ExaminationDto examinationDto = new ExaminationDto();
        examinationDto.setExam_id(examination.getExam_id());
        examinationDto.setName(examination.getName());
        examinationDto.setDescription(examination.getDescription());
        examinationDto.setCode(examination.getCode());
        examinationDto.setLevels(examination.getLevels().getLevels_id());
        examinationDto.setStatus(examination.getStatus());
        examinationDto.setCertificates(examination.getCertificates());
        examinationDto.setDateEstablished(examination.getDateEstablished());

        return examinationDto;
    }
}
