package com.etz.pocexaminationapi.pocexaminationapi.annotations;

import com.etz.pocexaminationapi.pocexaminationapi.model.Paper;
import com.etz.pocexaminationapi.pocexaminationapi.repository.ExamRepository;
import com.etz.pocexaminationapi.pocexaminationapi.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

@Component
public class PaperIdValidator implements ConstraintValidator<PaperIdConstraint, Long> {

    @Autowired
    ExamRepository examRepository;
    PaperRepository paperRepository;


        @Override
        public boolean isValid (Long papers, ConstraintValidatorContext context){
        return true;
    }
}
