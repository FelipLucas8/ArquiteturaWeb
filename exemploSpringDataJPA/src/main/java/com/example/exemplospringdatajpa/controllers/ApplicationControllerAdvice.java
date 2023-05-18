package com.example.exemplospringdatajpa.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exemplospringdatajpa.exceptions.ApiErrors;
import com.example.exemplospringdatajpa.exceptions.RegraNegocioException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {
    
    @ExceptionHandler(RegraNegocioException.class)
    public ApiErrors handlerRegraNegocioException(RegraNegocioException ex){
        return new ApiErrors(ex.getMessage());
    }

    @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
    public ApiErrors handlerConstraintValidationException(ConstraintViolationException ex){
        List<String> errors = ex.getConstraintViolations()
        .stream()
        .map(erro -> erro.getMessage())
        .collect(Collectors.toList());

        return new ApiErrors(errors);
    }
}
