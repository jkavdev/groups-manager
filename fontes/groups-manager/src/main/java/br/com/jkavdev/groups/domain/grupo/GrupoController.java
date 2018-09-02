package br.com.jkavdev.groups.domain.grupo;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.groups.event.RecursoCriadoEvent;
import br.com.jkavdev.groups.utils.ServiceMap;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/grupos")
public class GrupoController implements ServiceMap {

    @Autowired
    private GrupoService grupoService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping(params = "pesquisa")
    private List<GrupoDTO> filtrar(GrupoFilter filter) {
        return grupoService.filtrar(filter).stream()
                .map(g -> GrupoDTO.from(g))
                .collect(toList());
    }

    @GetMapping("/status")
    public List<StatusGrupoDTO> todosStatus() {
        return grupoService.todosStatus().stream()
                .map(g -> StatusGrupoDTO.from(g))
                .collect(toList());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        grupoService.remover(id);
    }

    @PostMapping
    public ResponseEntity<GrupoDTO> criar(@Valid @RequestBody GrupoDTO grupo, HttpServletResponse response) {
        Grupo grupoSalvo = grupoService.salvar(Grupo.from(grupo));
        publisher.publishEvent(new RecursoCriadoEvent(this, response, grupoSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(GrupoDTO.from(grupoSalvo));
    }

    @PutMapping("{idGrupo}/adicionarintegrante/{idIntegrante}")
    @ResponseStatus(HttpStatus.OK)
    public void adicionarIntegrante(@PathVariable Long idGrupo, @PathVariable Long idIntegrante) {
        grupoService.adicionarIntegrante(idGrupo, idIntegrante);
    }

}
