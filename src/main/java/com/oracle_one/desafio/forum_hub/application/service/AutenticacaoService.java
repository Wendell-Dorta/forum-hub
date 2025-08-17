package com.oracle_one.desafio.forum_hub.application.service;

import com.oracle_one.desafio.forum_hub.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails usuario = repository.buscarUsuarioCompletoPorEmail(username);
        if (usuario == null) {
            throw  new UsernameNotFoundException("Usuário não encontrado");
        }
        return usuario;
    }
}
