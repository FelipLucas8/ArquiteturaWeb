package com.example.exemplospringdatajpa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.exemplospringdatajpa.dtos.GeneroDTO;
import com.example.exemplospringdatajpa.dtos.FilmeDTO;
import com.example.exemplospringdatajpa.dtos.DadosFilmeDTO;
import com.example.exemplospringdatajpa.exceptions.RegraNegocioException;
import com.example.exemplospringdatajpa.model.Genero;
import com.example.exemplospringdatajpa.model.Filme;
import com.example.exemplospringdatajpa.repositories.GeneroRepository;
import com.example.exemplospringdatajpa.repositories.FilmeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmeServiceImpl implements FilmeService{
    private final FilmeRepository filmeRepository;
    private final GeneroRepository generoRepository;

    @Override
    @Transactional
    public Filme salvar(FilmeDTO filmeDTO) {
        Genero genero = generoRepository.findById(filmeDTO.getGeneroId())
        .orElseThrow(() -> new RegraNegocioException("Gênero não encontrado!"));

        Filme filme = new Filme();
        filme.setNome(filmeDTO.getNome());
        filme.setMinutagem(filmeDTO.getMinutagem());
        filme.setGenero(genero);

        return filmeRepository.save(filme);
    }

    @Override
    public DadosFilmeDTO ObterFilmePorId(Long id) {
        return filmeRepository.findById(id).map((Filme c ) -> {
            return DadosFilmeDTO.builder()
            .id(c.getId())
            .nome(c.getNome())
            .minutagem(c.getMinutagem())
            .genero(GeneroDTO.builder()
                .id(c.getGenero().getId())
                .nome(c.getGenero().getNome())
                .build()
                )
            .build();
        })
        .orElseThrow(() -> new RegraNegocioException("Filme não encontrado"));
    }

    @Override
    @Transactional
    public void remover(Long id) {
        filmeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editar(Long id, FilmeDTO filmeDTO) {
        Filme filme = filmeRepository.findById(id)
        .orElseThrow(() -> new RegraNegocioException("Filme não encontrado"));
        
            Genero genero = generoRepository.findById(
            filmeDTO.getGeneroId())
            .orElseThrow(() -> new RegraNegocioException("Gênero não encontrado"));

            filme.setNome((filmeDTO.getNome()));
            filme.setMinutagem((filmeDTO.getMinutagem()));
            filme.setGenero(genero);

            filmeRepository.save(filme);
    }

    @Override
    public List<DadosFilmeDTO> obterTodos() {
        return filmeRepository.findAll().stream().map((Filme f) -> {
            return DadosFilmeDTO.builder()
            .id(f.getId())
            .nome(f.getNome())
            .minutagem(f.getMinutagem())
            .genero(GeneroDTO.builder()
                .id(f.getGenero().getId())
                .nome(f.getGenero().getNome())
                .build())
            .build();
        }).collect(Collectors.toList());
    }
}
