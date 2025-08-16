package com.oracle_one.desafio.forum_hub.api.dto.topico;

import com.oracle_one.desafio.forum_hub.domain.enums.StatusTopico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        Long idDoCurso
) {
}
