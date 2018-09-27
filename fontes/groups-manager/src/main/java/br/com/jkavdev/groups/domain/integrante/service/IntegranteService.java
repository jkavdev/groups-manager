package br.com.jkavdev.groups.domain.integrante.service;

import br.com.jkavdev.groups.domain.integrante.dto.IntegranteDTO;
import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
import br.com.jkavdev.groups.domain.integrante.repository.IntegranteFilter;
import br.com.jkavdev.groups.domain.integrante.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntegranteService {

    @Autowired
    private IntegranteRepository integranteRepository;

    public void efetivarCadastro(Long id) {
        Integrante integrante = buscarPeloId(id);
        integrante.efetivarCadastro();
        integranteRepository.save(integrante);
    }

    public Integrante buscarPeloId(Long id) {
        Optional<Integrante> integrante = integranteRepository.findById(id);

        if (!integrante.isPresent())
            throw new EmptyResultDataAccessException(1);

        return integrante.get();
    }

    public Integrante salvar(Integrante integrante) {
        return integranteRepository.save(integrante);
    }

    public List<IntegranteDTO> filtrar(IntegranteFilter filter) {
        return integranteRepository.filtrar(filter);
    }

    public Integrante buscarGrupos(Long id) {
        return integranteRepository.integrantesComGrupos(id);
    }
}
