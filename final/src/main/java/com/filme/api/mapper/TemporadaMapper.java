package com.filme.api.mapper;

import com.filme.api.dto.EpisodioResponseDTO;
import com.filme.api.dto.TemporadaResponseDTO;
import com.filme.api.client.external.Episodio;
import com.filme.api.client.external.Temporadas;

import java.util.List;

public class TemporadaMapper {

    public static TemporadaResponseDTO toResponse(Temporadas temporada) {
        List<EpisodioResponseDTO> episodios = (temporada.episodios() == null
                ? List.<Episodio>of()
                :temporada.episodios())
                        .stream()
                        .map(ep -> new EpisodioResponseDTO(
                                ep.name(),
                                ep.airDate(),
                                ep.episodeNumber(),
                                ep.voteAverage(),
                                ep.overview()))
                        .toList();

        return new TemporadaResponseDTO(
                temporada.name(),
                temporada.seasonNumbers(),
                episodios);
    }
}
