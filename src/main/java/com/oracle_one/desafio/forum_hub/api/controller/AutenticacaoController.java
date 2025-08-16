package com.oracle_one.desafio.forum_hub.api.controller;

import com.oracle_one.desafio.forum_hub.api.dto.autenticacao.DadosAutenticacao;
import com.oracle_one.desafio.forum_hub.api.dto.autenticacao.DadosTokenJWT;
import com.oracle_one.desafio.forum_hub.domain.model.Usuario;
import com.oracle_one.desafio.forum_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import jakarta.xml.bind.annotation.XmlAnyElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
