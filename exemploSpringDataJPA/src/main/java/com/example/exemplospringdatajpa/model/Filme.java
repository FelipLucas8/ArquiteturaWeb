package com.example.exemplospringdatajpa.model;

import com.example.exemplospringdatajpa.validations.NomeFilme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    @NomeFilme
    private String nome;
    @Column(nullable = false)
    @Min(value=1, message = "Minutagem inválida")
    @Max(value=3, message = "Minutagem inválida")
    private int minutagem;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

}
