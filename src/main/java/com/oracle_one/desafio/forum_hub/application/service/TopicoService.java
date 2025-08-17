package com.oracle_one.desafio.forum_hub.application.service;

import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosCadastroTopico;
import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosDetalhamentoTopico;
import com.oracle_one.desafio.forum_hub.application.validation.ValidadorCadastroTopico;
import com.oracle_one.desafio.forum_hub.domain.model.Curso;
import com.oracle_one.desafio.forum_hub.domain.model.Topico;
import com.oracle_one.desafio.forum_hub.domain.model.Usuario;
import com.oracle_one.desafio.forum_hub.domain.repository.CursoRepository;
import com.oracle_one.desafio.forum_hub.domain.repository.TopicoRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidadorCadastroTopico> validadorCadastro;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public DadosDetalhamentoTopico cadastrar(DadosCadastroTopico dados) {
        validadorCadastro.forEach(v -> v.validar(dados));

        Usuario autor = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Curso curso = cursoRepository.getReferenceById(dados.idDoCurso());
        Topico topico = new Topico(dados.titulo(), dados.mensagem(), autor, curso);

        var topicoDoSalvo = topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topicoDoSalvo);
    }
}
