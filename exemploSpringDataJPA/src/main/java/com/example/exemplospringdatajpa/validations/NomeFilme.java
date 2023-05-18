package com.example.exemplospringdatajpa.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.exemplospringdatajpa.constraints.NomeFilmeConstraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NomeFilmeConstraint.class)
public @interface NomeFilme {
    String message() default "Nome fora do padrão";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
