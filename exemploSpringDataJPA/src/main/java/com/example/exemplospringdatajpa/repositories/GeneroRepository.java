package com.example.exemplospringdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.exemplospringdatajpa.model.Genero;

public interface GeneroRepository
                extends JpaRepository<Genero, Long> {

        @Query("select cc from Genero cc left join fetch cc.filmes c where cc.id = :id ")
        Genero findGeneroFetchFilmes(@Param("id") Long id);

}
