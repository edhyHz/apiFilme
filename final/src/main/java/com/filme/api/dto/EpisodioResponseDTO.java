package com.filme.api.dto;

public record EpisodioResponseDTO(
       String nome,
       String dataLancamento,
       Integer numeroEpisodios,
       Double nota,
       String sinopse
) {
}
