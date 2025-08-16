package com.oracle_one.desafio.forum_hub.api.dto.topico;

import com.oracle_one.desafio.forum_hub.domain.enums.StatusTopico;
import com.oracle_one.desafio.forum_hub.domain.model.Topico;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao,
        StatusTopico status,
        Boolean ativo,
        String autor,
        String curso
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getDataAtualizacao(),
                topico.getStatus(),
                topico.getAtivo(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome()
        );
    }
}
