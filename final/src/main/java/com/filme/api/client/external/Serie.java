package com.filme.api.client.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Serie(@JsonAlias("id") Integer id,
                    @JsonAlias("name") String name,
                    @JsonAlias("overview") String overview,
                    @JsonAlias("first_air_date") String firstAirDate,
                    @JsonAlias("vote_average") Double voteAverage,
                    @JsonAlias("number_of_seasons") Integer numberOfSeasons,
                    @JsonAlias("genres") List<Genero> genres){

}
