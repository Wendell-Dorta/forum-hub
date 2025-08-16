package com.oracle_one.desafio.forum_hub.api.dto.topico;

import com.oracle_one.desafio.forum_hub.domain.enums.StatusTopico;
import com.oracle_one.desafio.forum_hub.domain.model.Curso;
import com.oracle_one.desafio.forum_hub.domain.model.Topico;
import com.oracle_one.desafio.forum_hub.domain.model.Usuario;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long id,
        String tituo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autor,
        String curso
) {
    public DadosListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor().getNome(), topico.getCurso().getNome());
    }
}
