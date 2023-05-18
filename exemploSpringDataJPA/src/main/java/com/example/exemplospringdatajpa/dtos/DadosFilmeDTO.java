package com.example.exemplospringdatajpa.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosFilmeDTO {
    private Long id;
    private String nome;
    private Integer minutagem;
    private GeneroDTO genero;
}
