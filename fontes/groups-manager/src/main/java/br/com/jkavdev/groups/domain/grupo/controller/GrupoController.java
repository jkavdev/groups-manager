package br.com.jkavdev.groups.domain.grupo.controller;

import br.com.jkavdev.groups.domain.grupo.dto.GrupoDTO;
import br.com.jkavdev.groups.domain.grupo.entity.Grupo;
import br.com.jkavdev.groups.domain.grupo.entity.StatusGrupo;
import br.com.jkavdev.groups.domain.grupo.repository.GrupoFilter;
import br.com.jkavdev.groups.domain.grupo.service.GrupoService;
import br.com.jkavdev.groups.event.RecursoCriadoEvent;
import br.com.jkavdev.groups.utils.ServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/grupos")
public class GrupoController implements ServiceMap {

    @Autowired
    private GrupoService grupoService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping(params = "pesquisa")
    public List<GrupoDTO> filtrar(GrupoFilter filter) {
        return grupoService.filtrar(filter).stream()
                .map(g -> GrupoDTO.from(g))
                .collect(toList());
    }

    @GetMapping("/{grupoId}/eventos")
    public GrupoDTO getEventos(@PathVariable("grupoId") Long groupoId) {
        Optional<Grupo> opGrupo = grupoService.comEventos(groupoId);

        if (!opGrupo.isPresent())
            throw new EmptyResultDataAccessException(1);

        return GrupoDTO.comEventos(opGrupo.get());
    }

    @GetMapping("/{grupoId}/integrantes")
    public GrupoDTO getIntegrantes(@PathVariable("grupoId") Long groupoId) {
        Optional<Grupo> opGrupo = grupoService.comIntegrantes(groupoId);

        if (!opGrupo.isPresent())
            throw new EmptyResultDataAccessException(1);

        return GrupoDTO.comIntegrantes(opGrupo.get());
    }

    @GetMapping("/status")
    public List<StatusGrupo> todosStatus() {
        return Arrays.asList(StatusGrupo.values());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        grupoService.remover(id);
    }

    @PostMapping
    public ResponseEntity<GrupoDTO> criar(@Valid @RequestBody GrupoDTO dto, HttpServletResponse response) {
        Grupo grupoSalvo = grupoService.salvar(Grupo.from(dto));
        publisher.publishEvent(new RecursoCriadoEvent(this, response, grupoSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("{idGrupo}/adicionarintegrante/{idIntegrante}")
    @ResponseStatus(HttpStatus.OK)
    public void adicionarIntegrante(@PathVariable Long idGrupo, @PathVariable Long idIntegrante) {
        grupoService.adicionarIntegrante(idGrupo, idIntegrante);
    }

}
