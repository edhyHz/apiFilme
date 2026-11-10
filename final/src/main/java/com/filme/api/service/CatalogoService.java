package com.filme.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.filme.api.client.TmdbClient;
import com.filme.api.dto.TemporadaResponseDTO;
import com.filme.api.mapper.TemporadaMapper;
import com.filme.api.client.external.ResultadoBusca;
import com.filme.api.client.external.Temporadas;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogoService {

    private final ObjectMapper mapper = new ObjectMapper();
    private final TmdbClient client;
    private final FilmeService filmeService;
    private final SerieService serieService;
    private final TemporadaService temporadaService;

    private ResultadoBusca.Item primeiroResultado(String query) throws JsonProcessingException {
        String jsonBusca = client.buscar(query);
        ResultadoBusca busca = mapper.readValue(jsonBusca, ResultadoBusca.class);
        System.out.println(jsonBusca);



        return busca.results().stream()
                .filter(i -> "movie".equals(i.mediaType()) || "tv".equals(i.mediaType()))
                .findFirst()
                .orElse(null);
    }

    public Object buscarDetalhes(String query) throws JsonProcessingException{
        ResultadoBusca.Item item = primeiroResultado(query);
        if (item == null) {
            return "Nada encontrado para: " + query;
        }
        return switch (item.mediaType()) {
            case "movie" -> filmeService.converterJsonParaFilme(client.detalhesFilme(item.id()));
            case "tv"    -> serieService.converterJsonParaSerie(client.detalhesSerie(item.id()));
            default      -> "Tipo não tratado: " + item.mediaType();
        };
    }

    public TemporadaResponseDTO buscarTemporada(int serieId, int numero) throws JsonProcessingException {
        String jsonTemporada = client.temporada(serieId, numero);
        System.out.println("JSON temporada: " + jsonTemporada);
        Temporadas t = temporadaService.converterJsonParaTemporadas(jsonTemporada);
        System.out.println("Model: " + t);
        return TemporadaMapper.toResponse(t);
    }
}
