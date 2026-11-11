package com.filme.api.service;

import com.filme.api.Security.JwtService;
import com.filme.api.dto.AuthResponseDTO;
import com.filme.api.dto.CadastroRequestDTO;
import com.filme.api.dto.LoginRequestDTO;
import com.filme.api.dto.UsuarioResponseDTO;
import com.filme.api.entity.UsuarioEntity;
import com.filme.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Transactional
    public AuthResponseDTO cadastrar(CadastroRequestDTO request) {
        String email = normalizarEmail(request.email());

        if (usuarioRepository.existsByEmail(email)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "E-mail já cadastrado"
            );
        }

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome(request.nome().trim());
        usuario.setEmail(email);
        usuario.setSenhaHash(passwordEncoder.encode(request.senha()));

        usuarioRepository.save(usuario);
        return criarResposta(usuario);
    }

    public AuthResponseDTO login(LoginRequestDTO request) {
        String email = normalizarEmail(request.email());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, request.senha())
            );
        } catch (BadCredentialsException ex) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "E-mail ou senha inválidos"
            );
        }

        UsuarioEntity usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "E-mail ou senha inválidos"
                ));

        return criarResposta(usuario);
    }

    private AuthResponseDTO criarResposta(UsuarioEntity usuario) {
        String token = jwtService.gerarToken(usuario.getEmail());

        return new AuthResponseDTO(
                token,
                "Bearer",
                new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail())
        );
    }

    private String normalizarEmail(String email) {
        return email.trim().toLowerCase(Locale.ROOT);
    }
}
