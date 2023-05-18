package com.example.exemplospringdatajpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemplospringdatajpa.dtos.GeneroDTO;
import com.example.exemplospringdatajpa.model.Genero;
import com.example.exemplospringdatajpa.services.GeneroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/genero")
public class GeneroController {
    private GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genero salvar(@Valid @RequestBody GeneroDTO generoDTO){
        return generoService.salvar(generoDTO);
    }
    
}
