package com.oracle_one.desafio.forum_hub.application.validation.validadores;

import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosAtualizacaoTopico;
import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosCadastroTopico;
import com.oracle_one.desafio.forum_hub.application.validation.ValidadorAtualizacaoTopico;
import com.oracle_one.desafio.forum_hub.application.validation.ValidadorCadastroTopico;
import com.oracle_one.desafio.forum_hub.domain.exception.RegraDeNegocioException;
import com.oracle_one.desafio.forum_hub.domain.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoDuplicado implements ValidadorCadastroTopico, ValidadorAtualizacaoTopico {

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(DadosCadastroTopico dados) {
        var topicoDuplicado = repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem());

        if (topicoDuplicado) {
            throw new RegraDeNegocioException("Tópico duplicado: Já existe um tópico com o mesmo título e mensagem");
        }
    }

    @Override
    public void validar(DadosAtualizacaoTopico dados) {
        var topicoDuplicado = repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem());

        if (topicoDuplicado) {
            throw new RegraDeNegocioException("Tópico duplicado: Já existe um tópico com o mesmo título e mensagem");
        }
    }
}
