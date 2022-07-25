package com.etz.pocexaminationapi.pocexaminationapi.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Constraint(validatedBy = PaperIdValidator.class)
@Target({FIELD, PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PaperIdConstraint {
    String message() default "Invalid input, must be an integer value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };
}
