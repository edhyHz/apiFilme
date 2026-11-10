package com.filme.api.dto;

import java.util.List;

public record TemporadaResponseDTO(
        String nome,
        Integer numero,
        List<EpisodioResponseDTO> episodio
) {
}
