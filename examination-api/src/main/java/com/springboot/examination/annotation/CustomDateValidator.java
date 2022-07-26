package com.springboot.examination.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomDateValidator {
    String message() default "Invalid date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}