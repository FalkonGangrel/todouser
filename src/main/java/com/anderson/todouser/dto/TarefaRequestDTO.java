package com.anderson.todouser.dto;

import jakarta.validation.constraints.NotBlank;

public class TarefaRequestDTO {

    @NotBlank
    private String descricao;

    // getters e setters
}