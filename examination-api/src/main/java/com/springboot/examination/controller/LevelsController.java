package com.springboot.examination.controller;

import com.springboot.examination.payload.LevelsDto;
import com.springboot.examination.service.LevelsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/levels/")
public class LevelsController {
    private LevelsService levelsService;

    public LevelsController(LevelsService levelsService) {
        this.levelsService = levelsService;
    }

    @PostMapping("create")
    public ResponseEntity<LevelsDto> createPost(@RequestBody LevelsDto levelsDto) {
        return new ResponseEntity<>(levelsService.createPost(levelsDto), HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(value = "id") long id) {
        levelsService.deletePost(id);

        return new ResponseEntity<>("Post successfully deleted", HttpStatus.OK);
    }
}
