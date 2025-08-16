package com.oracle_one.desafio.forum_hub.domain.repository;

import com.oracle_one.desafio.forum_hub.domain.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
