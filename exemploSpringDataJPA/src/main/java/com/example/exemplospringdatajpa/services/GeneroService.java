package com.example.exemplospringdatajpa.services;

import com.example.exemplospringdatajpa.dtos.GeneroDTO;
import com.example.exemplospringdatajpa.model.Genero;

public interface GeneroService {
    Genero salvar(GeneroDTO genero);
}
