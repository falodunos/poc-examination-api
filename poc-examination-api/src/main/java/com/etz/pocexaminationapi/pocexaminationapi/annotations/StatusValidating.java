package com.etz.pocexaminationapi.pocexaminationapi.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class StatusValidating implements ConstraintValidator<StatusValidator, String> {

    @Override
    public boolean isValid(String statusName, ConstraintValidatorContext cxt) {
        List list = Arrays.asList(new String[]{"ACTIVE","INACTIVE"});
        return list.contains(statusName);
    }
}
