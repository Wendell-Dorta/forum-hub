package com.oracle_one.desafio.forum_hub.domain.repository;

import com.oracle_one.desafio.forum_hub.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
