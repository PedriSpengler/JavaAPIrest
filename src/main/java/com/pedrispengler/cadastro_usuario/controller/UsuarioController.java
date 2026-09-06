package com.pedrispengler.cadastro_usuario.controller;

import com.pedrispengler.cadastro_usuario.dto.UsuarioRequestDTO;
import com.pedrispengler.cadastro_usuario.dto.UsuarioResponseDTO;
import com.pedrispengler.cadastro_usuario.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuários", description = "Operações relacionadas a usuários")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Obter todos os usuários")
    public List<UsuarioResponseDTO> getAllUsuarios() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um usuário por ID", description = "Retorna os dados de um usuário específico com base no ID.")
    public UsuarioResponseDTO getUsuarioById(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Adicionar um novo usuário")
    public UsuarioResponseDTO addUsuario(@Valid @RequestBody UsuarioRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um usuário existente")
    public UsuarioResponseDTO updateUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um usuário")
    public void deleteUsuario(@PathVariable Long id) {
        service.deletar(id);
    }
}