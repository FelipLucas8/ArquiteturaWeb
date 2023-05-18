package com.example.exemplospringdatajpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exemplospringdatajpa.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
        List<Filme> findByNome(String nome);

        List<Filme> findByNomeLike(String nome);

}
