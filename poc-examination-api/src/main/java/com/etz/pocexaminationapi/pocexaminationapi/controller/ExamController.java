package com.etz.pocexaminationapi.pocexaminationapi.controller;

import com.etz.pocexaminationapi.pocexaminationapi.payload.ExamDto;
import com.etz.pocexaminationapi.pocexaminationapi.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class ExamController {

    private ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    // create examination api
    @PostMapping
    public ResponseEntity<ExamDto> createExam(@RequestBody ExamDto examDto){
        return new ResponseEntity<>(examService.createExam(examDto), HttpStatus.CREATED);
    }

    //get all posts rest api
    @GetMapping
    public List<ExamDto> getAllExams(){
        return examService.getAllExams();
    }

    //get post by id rest api
    @GetMapping("/{id}")
    public ResponseEntity<ExamDto> getExamById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(examService.getExamById(id));
    }

    //update post by id rest api
    @PutMapping("/{id}")
    public ResponseEntity<ExamDto> updateExam(@RequestBody ExamDto examDto, @PathVariable(name = "id") long id) {

        ExamDto examResponse = examService.updateExam(examDto, id);

        return new ResponseEntity<>(examResponse, HttpStatus.OK);
    }

    //delete post rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExam(@PathVariable(name = "id") long id){

        examService.deleteExamById(id);

        return new ResponseEntity<>("Exam entity deleted successfully.", HttpStatus.OK);
    }

}
