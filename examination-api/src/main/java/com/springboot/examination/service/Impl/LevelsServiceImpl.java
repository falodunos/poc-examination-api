package com.springboot.examination.service.Impl;

import com.springboot.examination.exception.ExaminationException;
import com.springboot.examination.model.Examination;
import com.springboot.examination.model.Levels;
import com.springboot.examination.payload.LevelsDto;
import com.springboot.examination.repository.LevelsRepository;
import com.springboot.examination.service.LevelsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LevelsServiceImpl implements LevelsService {

    private LevelsRepository levelsRepository;

    public LevelsServiceImpl(LevelsRepository levelsRepository) {
        this.levelsRepository = levelsRepository;
    }

    @Override
    public LevelsDto createPost(LevelsDto levelsDto) {
//      convert dto to entity
        Levels levels = mapToEntity(levelsDto);
//      save to database
        Levels newPost = levelsRepository.save(levels);
//      convert entity to dto
        LevelsDto response = mapToDto(newPost);

        return response;
    }

    @Override
    public void deletePost(long id) {
        Levels levels = levelsRepository.findById(id).orElseThrow(() -> new ExaminationException(HttpStatus.BAD_REQUEST, "Id does not exist"));
        levelsRepository.delete(levels);
    }

    //  convert dto to entity
    private Levels mapToEntity(LevelsDto levelsDto) {
        Levels levels = new Levels();
        levels.setEducation(levelsDto.getEducation());
//        levels.setPrimaryEducation(levelsDto.getPrimaryEducation());
//        levels.setSecondaryEducation(levelsDto.getSecondaryEducation());
//        levels.setAdultEducation(levelsDto.getAdultEducation());
//        levels.setTertiaryEducation(levelsDto.getTertiaryEducation());

        return levels;
    }

//  convert entity to dto
    private LevelsDto mapToDto(Levels levels) {
        LevelsDto levelsDto = new LevelsDto();
        levelsDto.setEducation(levels.getEducation());
//        levelsDto.setPrimaryEducation(levels.getPrimaryEducation());
//        levelsDto.setSecondaryEducation(levels.getSecondaryEducation());
//        levelsDto.setAdultEducation(levels.getAdultEducation());
//        levelsDto.setTertiaryEducation(levels.getTertiaryEducation());

        return levelsDto;
    }
}
