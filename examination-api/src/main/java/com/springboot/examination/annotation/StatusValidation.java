package com.springboot.examination.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class StatusValidation implements ConstraintValidator<StatusValidator, String> {

    @Override
    public boolean isValid(String status, ConstraintValidatorContext constraintValidatorContext) {
        List list = Arrays.asList(new String[]{"ACTIVE", "INACTIVE"});
        return list.contains(status);
    }
}
