package com.anderson.todouser.service;

import com.anderson.todouser.dto.UsuarioRequestDTO;
import com.anderson.todouser.dto.UsuarioResponseDTO;
import com.anderson.todouser.model.Usuario;
import com.anderson.todouser.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        repository.save(usuario);

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }

    public List<UsuarioResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(u -> new UsuarioResponseDTO(
                        u.getId(),
                        u.getNome(),
                        u.getEmail()))
                .collect(Collectors.toList());
    }
}