package com.filme.api.mapper;

import com.filme.api.dto.SerieResponseDTO;
import com.filme.api.client.external.Genero;
import com.filme.api.client.external.Serie;

import java.util.List;
import java.util.stream.Collectors;

public class SerieMapper {
    public static SerieResponseDTO toResponse(Serie serie) {
        List<String> generos = serie.genres() == null
                ? List.of()
                : serie.genres().stream()
                        .map(Genero::name)
                        .collect(Collectors.toList());

        return new SerieResponseDTO(
          serie.id(),
          serie.name(),
          serie.overview(),
          serie.firstAirDate(),
          serie.voteAverage(),
          serie.numberOfSeasons(),
          generos
        );
    }
}
