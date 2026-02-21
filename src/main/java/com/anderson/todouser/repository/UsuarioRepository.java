package com.anderson.todouser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anderson.todouser.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}