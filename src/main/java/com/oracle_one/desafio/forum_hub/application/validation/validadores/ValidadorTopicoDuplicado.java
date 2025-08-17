package com.oracle_one.desafio.forum_hub.application.validation.validadores;

import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosAtualizacaoTopico;
import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosCadastroTopico;
import com.oracle_one.desafio.forum_hub.application.validation.ValidadorAtualizacaoTopico;
import com.oracle_one.desafio.forum_hub.application.validation.ValidadorCadastroTopico;
import com.oracle_one.desafio.forum_hub.application.validation.ValidadorTopico;
import com.oracle_one.desafio.forum_hub.domain.exception.RegraDeNegocioException;
import com.oracle_one.desafio.forum_hub.domain.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
        if (dados.titulo() == null && dados.mensagem() == null) {
            return;
        }
        var topicoAtual = repository.getReferenceById(dados.id());
        String novoTitulo = (dados.titulo() != null) ? dados.titulo() : topicoAtual.getTitulo();
        String novaMensagem = (dados.mensagem() != null) ? dados.mensagem() : topicoAtual.getMensagem();

        if (repository.existsByTituloAndMensagemAndIdNot(novoTitulo, novaMensagem, dados.id())) {
            throw new RegraDeNegocioException("Tópico duplicado: Já existe outro tópico com este título e mensagem.");
        }
    }
}
