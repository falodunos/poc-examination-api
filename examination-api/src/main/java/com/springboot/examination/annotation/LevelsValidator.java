package com.springboot.examination.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, PARAMETER})
@Constraint(validatedBy = LevelsValidation.class)
public @interface LevelsValidator {
//  error message
    public String message() default "Invalid input: Required input is an Integer";
//  represents group of constraints
    public Class<?>[] groups() default{};
//  represents additional information about annotation
    public Class<? extends Payload>[] payload() default{};
}
