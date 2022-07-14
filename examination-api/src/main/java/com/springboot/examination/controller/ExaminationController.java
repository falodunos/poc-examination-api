package com.springboot.examination.controller;

import com.springboot.examination.payload.ExaminationDto;
import com.springboot.examination.service.ExaminationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/registrations/")
public class ExaminationController {
    private ExaminationService examinationService;

    public ExaminationController(ExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @PostMapping("create")
    public ResponseEntity<ExaminationDto> createRecord(@RequestBody ExaminationDto examinationDto) {
        return new ResponseEntity<>(examinationService.createRecord(examinationDto), HttpStatus.CREATED);
    }

    @GetMapping("read")
    public List<ExaminationDto> getAllRecords() {
        return examinationService.getAllRecords();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<ExaminationDto> getRecordByID(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(examinationService.getRecordById(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ExaminationDto> updateRecord(@PathVariable(name = "id") long id, @RequestBody ExaminationDto examinationDto) {
        ExaminationDto update = examinationService.updateRecordByID(id, examinationDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteRecordByID(@PathVariable long id) {
        examinationService.deleteRecordByID(id);

        return new ResponseEntity<>("Examination registration was successfully deleted", HttpStatus.OK);
    }

}
