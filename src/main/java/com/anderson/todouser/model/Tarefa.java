package com.anderson.todouser.model;

import jakarta.persistence.*;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private boolean concluida = false;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // getters e setters
}