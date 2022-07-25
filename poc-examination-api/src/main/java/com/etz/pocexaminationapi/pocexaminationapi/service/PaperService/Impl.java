package com.etz.pocexaminationapi.pocexaminationapi.service.PaperService;

import com.etz.pocexaminationapi.pocexaminationapi.exception.ResourceNotFoundException;
import com.etz.pocexaminationapi.pocexaminationapi.model.Paper;
import com.etz.pocexaminationapi.pocexaminationapi.payload.PaperDto;
import com.etz.pocexaminationapi.pocexaminationapi.repository.PaperRepository;
import com.etz.pocexaminationapi.pocexaminationapi.service.PaperInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Impl implements PaperInterface {

    private PaperRepository paperRepository;

    public Impl(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    @Override
    public PaperDto createPaper(PaperDto paperDto) {

        // convert Dto to entity
        Paper paper = mapToEntity(paperDto);
        Paper newPaper = paperRepository.save(paper);

        // convert entity to Dto
        PaperDto paperResponse = mapToDTO(newPaper);

        return paperResponse;
    }

    @Override
    public List<PaperDto> getAllPapers() {
        List<Paper> paper = paperRepository.findAll();
        return paper.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }

    @Override
    public PaperDto getPapersById(long id) {
        Paper paper = paperRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Paper", "id", id));
        return mapToDTO(paper);
    }

    @Override
    public PaperDto updatePaper(PaperDto paperDto, long id) {
        //get post by id from the database
        Paper paper = paperRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Paper", "id", id));

        paper.setName(paperDto.getName());
        paper.setDescription(paperDto.getDescription());

        Paper updatedPaper = paperRepository.save(paper);
        return mapToDTO(updatedPaper);
    }

    @Override
    public void deletePaperById(long id) {
        //get post by id from the database
        Paper paper = paperRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Paper", "id", id));
        paperRepository.delete(paper);
    }

    //convert Entity to DTO
    private PaperDto mapToDTO(Paper paper){
        PaperDto paperDto = new PaperDto();
        paperDto.setId(paper.getId());
        paperDto.setName(paper.getName());
        paperDto.setDescription(paper.getDescription());
        return paperDto;
    }

    // convert DTO to entity
    private Paper mapToEntity(PaperDto paperDto) {
        Paper paper = new Paper();
        paper.setName(paperDto.getName());
        paper.setDescription(paperDto.getDescription());
        return paper;
    }
}
