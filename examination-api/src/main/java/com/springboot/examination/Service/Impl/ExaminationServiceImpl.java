package com.springboot.examination.Service.Impl;

import com.springboot.examination.Model.Examination;
import com.springboot.examination.Payload.ExaminationDto;
import com.springboot.examination.Repository.ExaminationRepository;
import com.springboot.examination.Service.ExaminationService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExaminationServiceImpl implements ExaminationService {
    private ExaminationRepository examinationRepository;

    public ExaminationServiceImpl(ExaminationRepository examinationRepository) {
        this.examinationRepository = examinationRepository;
    }

    @Override
    public ExaminationDto createRecord(ExaminationDto examinationDto) {
//      convert client do to entity
        Examination examination = mapToEntity(examinationDto);
//      save to repository
        Examination newPost = examinationRepository.save(examination);
//      convert entity to dto
        ExaminationDto response = mapToDto(newPost);
        return response;
    }

    @Override
    public List<ExaminationDto> getAllRecords() {
        List<Examination> posts = examinationRepository.findAll();
        return posts.stream().map(examination -> mapToDto(examination)).collect(Collectors.toList());
    }

    @Override
    public ExaminationDto getRecordById(long id) {
        Examination examination = examinationRepository.findById(id).orElseThrow(() -> new RuntimeException("Examination"));
        return mapToDto(examination);
    }

    @Override
    public ExaminationDto updateRecordByID(long id, ExaminationDto examinationDto) {
        Examination examination = examinationRepository.findById(id).orElseThrow(() -> new RuntimeException("Examination"));

        examination.setName(examination.getName());
        examination.setDescription(examinationDto.getDescription());
        examination.setCode(examination.getCode());
        examination.setLevels(examination.getLevels());
        examination.setStatus(examinationDto.getStatus());
        examination.setCertificates(examinationDto.getCertificates());
        examination.setDateEstablished(examinationDto.getDateEstablished());

        Examination updatedPost = examinationRepository.save(examination);

        return mapToDto(updatedPost);
    }

    @Override
    public void deleteRecordByID(long id) {
        Examination examination = examinationRepository.findById(id).orElseThrow(() -> new RuntimeException("Examination"));
        examinationRepository.delete(examination);
    }

    //  convert from dto to entity
    private Examination mapToEntity(ExaminationDto examinationDto) {
        Examination examination = new Examination();
        examination.setName(examinationDto.getName());
        examination.setDescription(examinationDto.getDescription());
        examination.setCode(examinationDto.getCode());
        examination.setLevels(examinationDto.getLevels());
        examination.setStatus(examinationDto.getStatus());
        examination.setCertificates(examinationDto.getCertificates());
        examination.setDateEstablished(examinationDto.getDateEstablished());

        return examination;
    }

//  convert from entity to dto
    private ExaminationDto mapToDto(Examination examination) {
        ExaminationDto examinationDto = new ExaminationDto();
        examinationDto.setName(examination.getName());
        examinationDto.setDescription(examination.getDescription());
        examinationDto.setCode(examination.getCode());
        examinationDto.setLevels(examination.getLevels());
        examinationDto.setStatus(examination.getStatus());
        examinationDto.setCertificates(examination.getCertificates());
        examinationDto.setDateEstablished(examination.getDateEstablished());

        return examinationDto;
    }
}
