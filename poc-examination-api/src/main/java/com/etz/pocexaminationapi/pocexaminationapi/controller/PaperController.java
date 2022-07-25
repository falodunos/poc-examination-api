package com.etz.pocexaminationapi.pocexaminationapi.controller;

import com.etz.pocexaminationapi.pocexaminationapi.payload.PaperDto;
import com.etz.pocexaminationapi.pocexaminationapi.service.PaperInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paper")
public class PaperController {

    private PaperInterface paperInterface;

    public PaperController(PaperInterface paperInterface) {
        this.paperInterface = paperInterface;
    }

    // create examination api
    @PostMapping
    public ResponseEntity<PaperDto> createPaper(@RequestBody PaperDto paperDto){
        return new ResponseEntity<>(paperInterface.createPaper(paperDto), HttpStatus.CREATED);
    }

    //get all posts rest api
    @GetMapping
    public List<PaperDto> getAllPapers() {
        return paperInterface.getAllPapers();
    }

    //get post by id rest api
    @GetMapping("/{id}")
    public ResponseEntity<PaperDto> getPaperById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(paperInterface.getPapersById(id));
    }

    //update post by id rest api
    @PutMapping("/{id}")
    public ResponseEntity<PaperDto> updatePaper(@RequestBody PaperDto paperDto, @PathVariable(name = "id") long id) {

        PaperDto paperResponse = paperInterface.updatePaper(paperDto, id);

        return new ResponseEntity<>(paperResponse, HttpStatus.OK);
    }

    //delete post rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaper(@PathVariable(name = "id") long id){

        paperInterface.deletePaperById(id);

        return new ResponseEntity<>("Paper entity deleted successfully.", HttpStatus.OK);
    }

}
