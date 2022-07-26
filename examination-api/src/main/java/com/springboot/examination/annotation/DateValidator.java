package com.springboot.examination.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateValidator implements ConstraintValidator<CustomDateValidator, String> {
    private static final String DATE_PATTERN = "MM/dd/yyyy";

    @Override
    public void initialize(CustomDateValidator customDate) {
    }

    @Override
    public boolean isValid(String localDate, ConstraintValidatorContext constraintValidatorContext) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        try {
            sdf.setLenient(false);
            Date d = sdf.parse(String.valueOf(localDate));
            return true;
        }
        catch (ParseException e) {
            return false;
        }
    }


}
