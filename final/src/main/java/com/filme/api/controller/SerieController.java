package com.filme.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.filme.api.client.TmdbClient;
import com.filme.api.dto.SerieResponseDTO;
import com.filme.api.dto.TemporadaResponseDTO;
import com.filme.api.mapper.SerieMapper;
import com.filme.api.mapper.TemporadaMapper;
import com.filme.api.client.external.Serie;
import com.filme.api.client.external.Temporadas;
import com.filme.api.service.SerieService;
import com.filme.api.service.TemporadaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@AllArgsConstructor
@RestController
public class SerieController {

    private final TmdbClient client;
    private final TemporadaService temporadaService;
    private final SerieService serieService;

    @GetMapping("/series/{id}/temporadas/{numero}")
    public TemporadaResponseDTO temporada(@PathVariable int id, @PathVariable int numero) throws JsonProcessingException {
        System.out.printf(">>> ENTROU no endpoint de temporada: id= " + id + " numero= " + numero);
        String json = client.temporada(id, numero);
        Temporadas temporada = temporadaService.converterJsonParaTemporadas(json);
        return TemporadaMapper.toResponse(temporada);
    }

    @GetMapping("/serie/{id}")
    public SerieResponseDTO serie(@PathVariable int id) throws JsonProcessingException {
        String json = client.detalhesSerie(id);
        Serie serie = serieService.converterJsonParaSerie(json);
        return SerieMapper.toResponse(serie);
    }

}
