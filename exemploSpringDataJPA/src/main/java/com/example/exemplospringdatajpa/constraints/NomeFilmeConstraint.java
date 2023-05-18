package com.example.exemplospringdatajpa.constraints;

import com.example.exemplospringdatajpa.validations.NomeFilme;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NomeFilmeConstraint implements ConstraintValidator<NomeFilme, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if (!value.matches("^[A-Z][A-Za-z]*(\s+[A-Z][A-Za-z]*)*$")) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
