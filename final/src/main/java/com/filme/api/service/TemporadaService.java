package com.filme.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.filme.api.client.external.Temporadas;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Service
@AllArgsConstructor
public class TemporadaService {

    private final ObjectMapper mapper = new ObjectMapper();

    public Temporadas converterJsonParaTemporadas(String json) throws JsonProcessingException {
        return mapper.readValue(json, Temporadas.class);
    }
}
