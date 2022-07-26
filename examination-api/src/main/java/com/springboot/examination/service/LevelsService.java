package com.springboot.examination.service;

import com.springboot.examination.payload.LevelsDto;

public interface LevelsService {
    LevelsDto createPost(LevelsDto levelsDto);

    void deletePost(long id);
}
