package br.com.murielmagno.cadastro_colaboradores.controller;

import java.util.Arrays;
import java.util.List;

public class ApiErros {


    private List<String> erros;

    public ApiErros(List<String> erros) {
        this.erros = erros;
    }

    public ApiErros(String mensagem) {
        this.erros = Arrays.asList(mensagem);
    }

    public List<String> getErros() {
        return erros;
    }
}