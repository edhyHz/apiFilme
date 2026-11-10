package com.filme.api.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "séries")
public class SerieEntity {

    @Id
    private Long Id;

    private String name;
    private String firstAirDate;
    private Double voteAverage;
    private Integer numberOfSeasons;

    @Column(columnDefinition = "TEXT")
    private String overview;

    protected SerieEntity() {

    }
}
