package com.example.exemplospringdatajpa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmeDTO {
    private Long Id;
    private String nome;
    private Integer minutagem;
    private Long generoId;
}
