package com.oracle_one.desafio.forum_hub.application.validation.validadores;

import com.oracle_one.desafio.forum_hub.application.validation.ValidadorTopico;
import com.oracle_one.desafio.forum_hub.domain.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoNaoNulo implements ValidadorTopico {

    @Autowired
    private TopicoRepository repository;

    public void validar(Long id) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico com id " + id + " não encontrado."));
    }
}
