package com.filme.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import tools.jackson.databind.ObjectMapper;

public class ConversorService {

    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T converter(String json, Class<T> tipo) throws JsonProcessingException {
        return mapper.readValue(json, tipo);
    }
}
