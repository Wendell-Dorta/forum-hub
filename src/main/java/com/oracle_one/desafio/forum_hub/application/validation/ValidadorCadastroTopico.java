package com.oracle_one.desafio.forum_hub.application.validation;

import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosCadastroTopico;

public interface ValidadorCadastroTopico {
    void validar(DadosCadastroTopico dados);
}
