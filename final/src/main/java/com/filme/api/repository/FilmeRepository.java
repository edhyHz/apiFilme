package com.filme.api.repository;

import com.filme.api.entity.FilmeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<FilmeEntity, Long> {
}
