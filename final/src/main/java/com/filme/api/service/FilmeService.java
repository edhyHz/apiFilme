package com.filme.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.filme.api.client.external.Filme;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmeService {

    private final ObjectMapper mapper = new ObjectMapper();

    public Filme converterJsonParaFilme(String json) throws JsonProcessingException {
        return mapper.readValue(json, Filme.class);
    }
}
