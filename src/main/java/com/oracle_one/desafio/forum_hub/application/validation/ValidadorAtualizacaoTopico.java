package com.oracle_one.desafio.forum_hub.application.validation;

import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosAtualizacaoTopico;

public interface ValidadorAtualizacaoTopico {
    void validar(DadosAtualizacaoTopico dados);
}
