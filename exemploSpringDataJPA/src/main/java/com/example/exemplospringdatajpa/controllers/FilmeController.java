package com.example.exemplospringdatajpa.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemplospringdatajpa.dtos.DadosFilmeDTO;
import com.example.exemplospringdatajpa.dtos.FilmeDTO;
import com.example.exemplospringdatajpa.model.Filme;
import com.example.exemplospringdatajpa.services.FilmeService;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/filme")
public class FilmeController {
    private FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Filme salvar(@Valid @RequestBody FilmeDTO filmeDTO){
        return filmeService.salvar(filmeDTO);
    }

    @GetMapping("{id}")
    public DadosFilmeDTO getFilmePorId(@PathVariable Long id){
        return filmeService.ObterFilmePorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFilmeById(@PathVariable Long id){
        filmeService.remover(id);
    }

    @PutMapping("{id}")
    public void editarFilme(@PathVariable Long id, @RequestBody FilmeDTO dto){
        filmeService.editar(id, dto);
    }

    @GetMapping
    public List<DadosFilmeDTO> obterTodos(){
        return filmeService.obterTodos();
    }

}
