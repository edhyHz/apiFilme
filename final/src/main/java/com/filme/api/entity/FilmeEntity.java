package com.filme.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "filmes")
public class FilmeEntity {

    @Id
    private Long id;

    private String title;
    private String releaseDate;
    private Double voteAverage;
    private Integer runtime;

    @Column(columnDefinition = "TEXT")
    private String overview;

    protected FilmeEntity() {

    }
}
