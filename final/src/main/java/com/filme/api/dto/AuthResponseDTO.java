package com.filme.api.dto;

public record AuthResponseDTO(
        String accessToken,
        String tokenType,
        UsuarioResponseDTO usuario
) {
}
