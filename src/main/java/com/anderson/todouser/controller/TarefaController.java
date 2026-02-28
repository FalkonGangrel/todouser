package com.anderson.todouser.controller;

import com.anderson.todouser.dto.TarefaRequestDTO;
import com.anderson.todouser.dto.TarefaResponseDTO;
import com.anderson.todouser.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios/{usuarioId}/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public TarefaResponseDTO criar(@PathVariable Long usuarioId,
                                   @RequestBody @Valid TarefaRequestDTO dto) {
        return service.criar(usuarioId, dto);
    }

    @GetMapping
    public List<TarefaResponseDTO> listar(@PathVariable Long usuarioId) {
        return service.listarPorUsuario(usuarioId);
    }

    @PatchMapping("/{tarefaId}/concluir")
    public TarefaResponseDTO concluir(@PathVariable Long usuarioId,
                                      @PathVariable Long tarefaId) {
        return service.concluir(tarefaId);
    }
}