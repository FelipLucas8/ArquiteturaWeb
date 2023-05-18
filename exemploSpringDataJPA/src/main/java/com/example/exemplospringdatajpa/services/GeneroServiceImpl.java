package com.example.exemplospringdatajpa.services;

import org.springframework.stereotype.Service;

import com.example.exemplospringdatajpa.dtos.GeneroDTO;
import com.example.exemplospringdatajpa.exceptions.RegraNegocioException;
import com.example.exemplospringdatajpa.model.Genero;
import com.example.exemplospringdatajpa.repositories.GeneroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeneroServiceImpl implements GeneroService {

    private final GeneroRepository generoRepository;

    @Override
    public Genero salvar(GeneroDTO generoDto) {
        try{
            Genero genero = new Genero();
            genero.setNome(generoDto.getNome());
            return generoRepository.save(genero);
        }catch(Exception ex){
            throw new RegraNegocioException("Houve um erro ao salvar");
        }
    }
    
}
