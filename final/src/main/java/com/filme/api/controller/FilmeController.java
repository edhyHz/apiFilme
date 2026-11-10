package com.filme.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.filme.api.client.TmdbClient;
import com.filme.api.dto.FilmeResponseDTO;
import com.filme.api.mapper.FilmeMapper;
import com.filme.api.client.external.Filme;
import com.filme.api.service.CatalogoService;
import com.filme.api.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class FilmeController {

    private final TmdbClient client;
    private final CatalogoService catalogo;
    private final FilmeService filmeService;

    @GetMapping("/filme/{id}")
    public FilmeResponseDTO filme(@PathVariable int id) throws JsonProcessingException {
        String json = client.detalhesFilme(id);
        Filme filme = filmeService.converterJsonParaFilme(json);
        return FilmeMapper.toResponse(filme);
    }

}
