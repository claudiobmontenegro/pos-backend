package com.kamikase.web.posbackend.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ClubeValidator.class)
public @interface ClubeValidation {
    String message() default "O nome de clube não é válido:  ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
