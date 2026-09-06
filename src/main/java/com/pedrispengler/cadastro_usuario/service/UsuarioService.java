package com.pedrispengler.cadastro_usuario.service;

import com.pedrispengler.cadastro_usuario.dto.UsuarioRequestDTO;
import com.pedrispengler.cadastro_usuario.dto.UsuarioResponseDTO;
import com.pedrispengler.cadastro_usuario.controller.RegraNegocioException;
import com.pedrispengler.cadastro_usuario.model.Usuario;
import com.pedrispengler.cadastro_usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(UsuarioResponseDTO::deEntidade)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {
        repository.findByEmail(dto.email()).ifPresent(u -> {
            throw new RegraNegocioException("Já existe um usuário cadastrado com este e-mail.");
        });

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());

        Usuario salvo = repository.save(usuario);
        return UsuarioResponseDTO.deEntidade(salvo);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        // Verifica se o usuário existe
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado com o ID: " + id));

        // Verifica se o e-mail já pertence a outro usuário
        repository.findByEmail(dto.email()).ifPresent(u -> {
            if (!u.getId().equals(id)) {
                throw new RegraNegocioException("Já existe um usuário cadastrado com este e-mail.");
            }
        });

        // Atualiza os dados
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());

        // Salva e converte para Response DTO
        Usuario atualizado = repository.save(usuario);
        return UsuarioResponseDTO.deEntidade(atualizado);
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado com o ID: " + id));
        return UsuarioResponseDTO.deEntidade(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}