package com.example.exemplospringdatajpa.exceptions;

public class RegraNegocioException extends RuntimeException{
    public RegraNegocioException(String mensagemErro){
        super(mensagemErro);
    }
}
