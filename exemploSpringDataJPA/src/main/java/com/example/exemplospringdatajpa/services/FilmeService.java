package com.example.exemplospringdatajpa.services;

import java.util.List;

import com.example.exemplospringdatajpa.dtos.FilmeDTO;
import com.example.exemplospringdatajpa.dtos.DadosFilmeDTO;
import com.example.exemplospringdatajpa.model.Filme;

public interface FilmeService {
    Filme salvar(FilmeDTO cursoDTO);
    DadosFilmeDTO ObterFilmePorId(Long id);
    void remover(Long id);
    void editar(Long id, FilmeDTO cursoDTO);
    List<DadosFilmeDTO> obterTodos();
}
