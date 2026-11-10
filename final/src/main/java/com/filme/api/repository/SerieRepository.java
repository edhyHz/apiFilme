package com.filme.api.repository;

import com.filme.api.entity.SerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<SerieEntity, Long> {
}
