package com.anderson.todouser.service;

import com.anderson.todouser.dto.TarefaRequestDTO;
import com.anderson.todouser.dto.TarefaResponseDTO;
import com.anderson.todouser.exception.ResourceNotFoundException;
import com.anderson.todouser.model.Tarefa;
import com.anderson.todouser.model.Usuario;
import com.anderson.todouser.repository.TarefaRepository;
import com.anderson.todouser.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    public TarefaService(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public TarefaResponseDTO criar(Long usuarioId, TarefaRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + usuarioId));

        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setUsuario(usuario);

        tarefaRepository.save(tarefa);

        return toDTO(tarefa);
    }

    public List<TarefaResponseDTO> listarPorUsuario(Long usuarioId) {
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new ResourceNotFoundException("Usuário não encontrado: " + usuarioId);
        }
        return tarefaRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TarefaResponseDTO concluir(Long tarefaId) {
        Tarefa tarefa = tarefaRepository.findById(tarefaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada: " + tarefaId));

        tarefa.setConcluida(true);
        tarefaRepository.save(tarefa);

        return toDTO(tarefa);
    }

    private TarefaResponseDTO toDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getDescricao(),
                tarefa.isConcluida(),
                tarefa.getUsuario().getId()
        );
    }
}