package com.filme.api.controller;

import com.filme.api.dto.AuthResponseDTO;
import com.filme.api.dto.CadastroRequestDTO;
import com.filme.api.dto.LoginRequestDTO;
import com.filme.api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/cadastro")
    public AuthResponseDTO cadastrar(@Valid @RequestBody CadastroRequestDTO request) {
        return authService.cadastrar(request);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@Valid @RequestBody LoginRequestDTO request) {
        return authService.login(request);
    }
}
