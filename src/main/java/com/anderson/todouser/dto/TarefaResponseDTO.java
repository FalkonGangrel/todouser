package com.anderson.todouser.dto;

public class TarefaResponseDTO {

    private Long id;
    private String descricao;
    private boolean concluida;
    private Long usuarioId;

    public TarefaResponseDTO(Long id, String descricao, boolean concluida, Long usuarioId) {
        this.id = id;
        this.descricao = descricao;
        this.concluida = concluida;
        this.usuarioId = usuarioId;
    }

    public Long getId() { return id; }
    public String getDescricao() { return descricao; }
    public boolean isConcluida() { return concluida; }
    public Long getUsuarioId() { return usuarioId; }
}