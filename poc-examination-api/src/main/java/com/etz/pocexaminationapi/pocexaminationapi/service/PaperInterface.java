package com.etz.pocexaminationapi.pocexaminationapi.service;

import com.etz.pocexaminationapi.pocexaminationapi.payload.PaperDto;

import java.util.List;

public interface PaperInterface {
    PaperDto createPaper(PaperDto paperDto);

    List<PaperDto> getAllPapers();

    PaperDto getPapersById(long id);

    PaperDto updatePaper(PaperDto paperDto, long id);

    void deletePaperById(long id);
}