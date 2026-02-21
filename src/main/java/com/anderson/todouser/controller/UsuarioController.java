package com.anderson.todouser.controller;

import com.anderson.todouser.dto.UsuarioRequestDTO;
import com.anderson.todouser.dto.UsuarioResponseDTO;
import com.anderson.todouser.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public UsuarioResponseDTO criar(@RequestBody @Valid UsuarioRequestDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return service.listar();
    }
}