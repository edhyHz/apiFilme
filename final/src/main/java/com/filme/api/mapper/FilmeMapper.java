package com.filme.api.mapper;

import com.filme.api.dto.FilmeResponseDTO;
import com.filme.api.client.external.Filme;
import com.filme.api.client.external.Genero;

public class FilmeMapper {
    public static FilmeResponseDTO toResponse(Filme filme) {
        var generos = filme.genres().stream()
                .map(Genero::name)
                .toList();

        return new FilmeResponseDTO(
                filme.id(),
                filme.title(),
                filme.overview(),
                filme.releaseDate(),
                filme.voteAverage(),
                filme.runtime(),
                generos);
    }

}
