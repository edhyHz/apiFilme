package com.filme.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.filme.api.service.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CatalogoController {

    private final CatalogoService catalogo;

    @GetMapping("/busca")
    public Object buscar(@RequestParam String titulo) throws JsonProcessingException {
        return catalogo.buscarDetalhes(titulo);
    }

}
