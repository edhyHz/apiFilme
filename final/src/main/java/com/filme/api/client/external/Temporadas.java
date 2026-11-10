package com.filme.api.client.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Temporadas(@JsonAlias("name") String name,
                         @JsonAlias("season_number") Integer seasonNumbers,
                         @JsonAlias("episodes")List<Episodio> episodios) {

}
