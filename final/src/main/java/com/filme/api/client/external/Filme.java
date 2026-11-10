package com.filme.api.client.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Filme(@JsonAlias("id") Integer id,
                    @JsonAlias("title") String title,
                    @JsonAlias("overview") String overview,
                    @JsonAlias("release_date") String releaseDate,
                    @JsonAlias("vote_average") Double voteAverage,
                    @JsonAlias("runtime") Integer runtime,
                    @JsonAlias("genres") List<Genero> genres) {
}
