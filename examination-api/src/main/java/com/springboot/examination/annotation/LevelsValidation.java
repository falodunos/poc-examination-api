package com.springboot.examination.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class LevelsValidation implements ConstraintValidator<LevelsValidator, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List list = Arrays.asList(new String[] {"1", "2", "3", "4"});
        return list.contains(s);
    }
}
