package com.filme.api.dto;

import java.util.List;

public record FilmeResponseDTO(
        Integer id,
        String titulo,
        String sinopse,
        String dataLancamento,
        Double nota,
        Integer duracao,
        List<String> generos

) {
}
