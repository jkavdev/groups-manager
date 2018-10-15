package br.com.jkavdev.groups.domain.grupo.service;

import br.com.jkavdev.groups.domain.evento.service.EventoService;
import br.com.jkavdev.groups.domain.grupo.entity.Grupo;
import br.com.jkavdev.groups.domain.grupo.repository.GrupoFilter;
import br.com.jkavdev.groups.domain.grupo.repository.GrupoRepository;
import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
import br.com.jkavdev.groups.domain.integrante.service.IntegranteService;
import br.com.jkavdev.groups.domain.noticia.service.NoticiaService;
import br.com.jkavdev.groups.exceptionhandler.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private IntegranteService integranteService;
    @Autowired
    private EventoService eventoService;
    @Autowired
    private NoticiaService noticiaService;

    public void remover(Long id) {
        if (grupoRepository.countByIntegrantes(id) > 0) {
            throw new NegocioException("grupo.com-integrantes");
        }

        Grupo grupo = grupoRepository.grupoTodosDados(id);
        grupo.getEventos().forEach(e -> eventoService.remover(e.getId()));
        grupo.getNoticias().forEach(n -> noticiaService.remover(n.getId()));

        grupoRepository.delete(grupo);
    }

    public List<Grupo> filtrar(GrupoFilter filter) {
        return grupoRepository.filtrar(filter);
    }

    public Grupo salvar(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public Optional<Grupo> comEventos(Long id) {
        return grupoRepository.findByIdFetchEventos(id);
    }

    public Grupo comIntegrantes(Long groupoId) {
        Optional<Grupo> opGrupo = grupoRepository.findByIdFetchIntegrantes(groupoId);
        opGrupo.orElseThrow(() -> new EmptyResultDataAccessException(1));
        return opGrupo.get();
    }

    public List<Grupo> gruposComIntegrantes() {
        return grupoRepository.gruposComIntegrantes();
    }

    public List<Grupo> gruposComNoticias() {
        return grupoRepository.gruposComNoticias();
    }

    public void adicionarIntegrante(Long idGrupo, Long idIntegrante) {
        Grupo grupo = comIntegrantes(idGrupo);
        Integrante integrante = integranteService.buscarPeloId(idIntegrante);
        grupo.adicionar(integrante);
        grupoRepository.save(grupo);
    }

    public Grupo buscarPor(Long id) {
        Optional<Grupo> op = grupoRepository.findById(id);
        op.orElseThrow(() -> new EmptyResultDataAccessException(1));
        return op.get();
    }

    public void atualizar(Long id, Grupo grupo) {
        Grupo grupoSalvo = buscarPor(id);
        grupoSalvo.atualizarDadosBasicos(grupo);
        grupoRepository.save(grupoSalvo);
    }

    public void vincularIntegrantes(Long idGrupo, List<Integrante> integrantes) {
        Grupo grupo = comIntegrantes(idGrupo);
        grupo.adicionar(integrantes);
        grupoRepository.save(grupo);
    }
}
