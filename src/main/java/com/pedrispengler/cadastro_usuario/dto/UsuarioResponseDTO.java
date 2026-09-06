package com.pedrispengler.cadastro_usuario.dto;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email
) {
    // Método auxiliar para converter a Entity em Response DTO
    public static UsuarioResponseDTO deEntidade(com.pedrispengler.cadastro_usuario.model.Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}