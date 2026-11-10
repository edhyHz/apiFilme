package com.filme.api.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class TmdbClient {

    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static final String API_KEY = "bdc74d13079ba191dfa9027b9e074b93";

    private final RestTemplate restTemplate = new RestTemplate();

    public String buscar(String query) {
        String q = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String url = BASE_URL + "/search/multi?query=" + query + "&language=pt-BR&api_key=" + API_KEY;
        System.out.println("URL de Busca: " + url);
        return get(BASE_URL + "/search/multi?query=" + query + "&language=pt-BR&api_key=" + API_KEY);
    }

    public String detalhesFilme(int id) {
        return get(BASE_URL + "/movie/" + id + "?language=pt-BR&api_key=" + API_KEY);
    }

    public String detalhesSerie(int id) {
        return get(BASE_URL + "/tv/" + id + "?language=pt-BR&api_key=" + API_KEY);
    }

    public String temporada(int serieID, int season) {
        String url = BASE_URL + "/tv/" + serieID + "/season/" + season + "?language=pt-BR&api_key=" + API_KEY;
        System.out.println("URL temporada: " + url);
        return get(BASE_URL + "/tv/" + serieID + "/season/" + season + "?language=pt-BR&api_key=" + API_KEY);
    }

    private String get(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> requesEntity = new HttpEntity<>(headers);

        String resposta = restTemplate.getForObject(url, String.class);
        if (resposta == null || resposta.isEmpty()) {
            System.err.println("Erro: O resultado a API está vazio ou nulo.");
            return null;
        }
        return resposta;
    }
}
