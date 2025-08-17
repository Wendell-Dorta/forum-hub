package com.oracle_one.desafio.forum_hub.application.service;

import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosAtualizacaoTopico;
import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosCadastroTopico;
import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosDetalhamentoTopico;
import com.oracle_one.desafio.forum_hub.api.dto.topico.DadosListagemTopico;
import com.oracle_one.desafio.forum_hub.application.validation.ValidadorAtualizacaoTopico;
import com.oracle_one.desafio.forum_hub.application.validation.ValidadorCadastroTopico;
import com.oracle_one.desafio.forum_hub.application.validation.ValidadorTopico;
import com.oracle_one.desafio.forum_hub.domain.model.Curso;
import com.oracle_one.desafio.forum_hub.domain.model.Topico;
import com.oracle_one.desafio.forum_hub.domain.model.Usuario;
import com.oracle_one.desafio.forum_hub.domain.repository.CursoRepository;
import com.oracle_one.desafio.forum_hub.domain.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private List<ValidadorCadastroTopico> validadorCadastroTopicos;

    @Autowired
    private List<ValidadorTopico> validadorTopicos;

    @Transactional
    public DadosDetalhamentoTopico cadastrar(DadosCadastroTopico dados) {
        validadorCadastroTopicos.forEach(v -> v.validar(dados));

        Usuario autor = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Curso curso = cursoRepository.getReferenceById(dados.idDoCurso());
        Topico topico = new Topico(dados.titulo(), dados.mensagem(), autor, curso);

        var topicoDoSalvo = topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topicoDoSalvo);
    }

    public Page<DadosListagemTopico> listar(Pageable paginacao) {
        var page = topicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemTopico::new);
        return page;
    }

    public DadosDetalhamentoTopico detalhar(Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return new DadosDetalhamentoTopico(topico);
    }

    @Transactional
    public DadosDetalhamentoTopico atualizar(DadosAtualizacaoTopico dados) {
        var topico = topicoRepository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
        topicoRepository.saveAndFlush(topico);

        return new DadosDetalhamentoTopico(topico);
    }

    @Transactional
    public void deletar(Long id) {
        validadorTopicos.forEach(v -> v.validar(id));
        var topico = topicoRepository.getReferenceById(id);
        topico.excluir();
    }
}