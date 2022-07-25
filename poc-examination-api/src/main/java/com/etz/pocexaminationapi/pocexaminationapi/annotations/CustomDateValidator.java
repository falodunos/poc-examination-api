package com.etz.pocexaminationapi.pocexaminationapi.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CustomDateValidator implements ConstraintValidator<CustomDateConstraint, String> {

    private static final String DATE_PATTERN = "dd/MM/yyyy";

    @Override
    public void initialize(CustomDateConstraint customDate) {
    }

    @Override
    public boolean isValid(String customDateField, ConstraintValidatorContext cxt) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        try
        {
            sdf.setLenient(false);
            Date d = sdf.parse(String.valueOf(customDateField));
            return true;
        }
        catch (ParseException e)
        {
            return false;
        }
    }

}
