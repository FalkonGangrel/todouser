package com.anderson.todouser.dto;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;

    public UsuarioResponseDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // getters
}