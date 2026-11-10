package com.filme.api.client.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Episodio(@JsonAlias("name") String name,
                       @JsonAlias("air_date") String airDate,
                       @JsonAlias("episode_number") Integer episodeNumber,
                       @JsonAlias("vote_average") Double voteAverage,
                       @JsonAlias("overview") String overview) {
}
