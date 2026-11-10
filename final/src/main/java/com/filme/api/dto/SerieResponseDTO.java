package com.filme.api.dto;

import java.util.List;

public record SerieResponseDTO(
        Integer id,
        String titulo,
        String sinopse,
        String dataEstreia,
        Double nota,
        Integer totalTemporadas,
        List<String> generos
) {
}
