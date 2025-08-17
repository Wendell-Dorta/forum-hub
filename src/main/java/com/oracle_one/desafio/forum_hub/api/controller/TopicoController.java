package com.oracle_one.desafio.forum_hub.api.controller;

import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosAtualizacaoTopico;
import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosCadastroTopico;
import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosListagemTopico;
import com.oracle_one.desafio.forum_hub.application.service.TopicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var topico = topicoService.cadastrar(dados);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.id()).toUri();
        return ResponseEntity.created(uri).body(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listagem(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = topicoService.listar(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = topicoService.detalhar(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = topicoService.atualizar(dados);
        return ResponseEntity.ok(topico);
    }
}
