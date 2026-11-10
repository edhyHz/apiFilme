package com.filme.api.client.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadoBusca(
        @JsonAlias("results")List<Item> results
        ) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Item(Integer id,
                       @JsonAlias("media_type") String mediaType,
                       @JsonAlias("title") String title,
                       @JsonAlias("name") String name){

    }
}
