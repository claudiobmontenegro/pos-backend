package com.kamikase.web.posbackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class ClubeValidator implements ConstraintValidator<ClubeValidation, String> {

    private Set<String> nomesInvalidos = new HashSet<>();
    private String mensagem;

    @Override
    public void initialize(ClubeValidation constraintAnnotation) {
        this.mensagem = constraintAnnotation.message();
        nomesInvalidos.add("Fluminense");
        nomesInvalidos.add("Flamengo");
        nomesInvalidos.add("Botafogo");
        nomesInvalidos.add("Vasco");
    }

    @Override
    public boolean isValid(String nomeClube, ConstraintValidatorContext context) {
        if (nomeClube == null || nomesInvalidos.contains(nomeClube)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(mensagem + nomeClube)
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}

