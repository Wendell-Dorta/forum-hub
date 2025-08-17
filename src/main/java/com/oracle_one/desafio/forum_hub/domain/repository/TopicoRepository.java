package com.oracle_one.desafio.forum_hub.domain.repository;

import com.oracle_one.desafio.forum_hub.domain.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);

    Page<Topico> findAllByAtivoTrue(Pageable paginacao);
}
