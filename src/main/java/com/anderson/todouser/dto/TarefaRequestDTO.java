package com.anderson.todouser.dto;

import jakarta.validation.constraints.NotBlank;

public class TarefaRequestDTO {

    @NotBlank
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}