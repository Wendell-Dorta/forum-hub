package com.oracle_one.desafio.forum_hub.api.dto.topico;

import com.oracle_one.desafio.forum_hub.domain.enums.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        StatusTopico status
) {
}
