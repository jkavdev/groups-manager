package br.com.jkavdev.groups.domain.grupo.service;

import br.com.jkavdev.groups.domain.grupo.entity.Grupo;
import br.com.jkavdev.groups.domain.grupo.repository.GrupoFilter;
import br.com.jkavdev.groups.domain.grupo.repository.GrupoRepository;
import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
import br.com.jkavdev.groups.domain.integrante.repository.IntegranteRepository;
import br.com.jkavdev.groups.exceptionhandler.NegocioException;
import org.springframework.beans.BeanUtils;
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
    private IntegranteRepository integranteRepository;

    public void remover(Long id) {

        if (grupoRepository.countByIntegrantes(id) > 0) {
            throw new NegocioException("grupo.com-integrantes");
        }

        grupoRepository.deleteById(id);
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

    public Optional<Grupo> comIntegrantes(Long groupoId) {
        return grupoRepository.findByIdFetchIntegrantes(groupoId);
    }

    public void adicionarIntegrante(Long idGrupo, Long idIntegrante) {
        Optional<Grupo> opGrupo = grupoRepository.findByIdFetchIntegrantes(idGrupo);
        opGrupo.orElseThrow(() -> new EmptyResultDataAccessException(1));
        Optional<Integrante> opIntegrante = integranteRepository.findById(idIntegrante);
        opIntegrante.orElseThrow(() -> new EmptyResultDataAccessException(1));

        Grupo grupo = opGrupo.get();
        grupo.adicionar(opIntegrante.get());

        grupoRepository.save(grupo);
    }

    public Grupo buscarPor(Long id) {
        return grupoRepository.findById(id).get();
    }

    public void atualizar(Long id, Grupo grupo) {
        Grupo grupoSalvo = buscarPor(id);
        grupoSalvo.atualizarDadosBasicos(grupo);
        grupoRepository.save(grupoSalvo);
    }
}
