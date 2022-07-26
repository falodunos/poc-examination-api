package com.springboot.examination.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = StatusValidation.class)
public @interface StatusValidator {
//  error message
    public String message() default "Invalid Status: Status can only be ACTIVE/INACTIVE";
//  represents group of constraints
    public Class<?>[] groups() default {};
//  represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
