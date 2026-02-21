package com.anderson.todouser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anderson.todouser.model.Tarefa;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByUsuarioId(Long usuarioId);
}