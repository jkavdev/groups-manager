package br.com.jkavdev.groups.domain.noticia.controller;

import br.com.jkavdev.groups.domain.grupo.dto.GrupoDTO;
import br.com.jkavdev.groups.domain.grupo.service.GrupoService;
import br.com.jkavdev.groups.domain.noticia.dto.NoticiaDTO;
import br.com.jkavdev.groups.domain.noticia.entity.Noticia;
import br.com.jkavdev.groups.domain.noticia.entity.Topico;
import br.com.jkavdev.groups.domain.noticia.repository.NoticiaRepository;
import br.com.jkavdev.groups.domain.noticia.service.NoticiaService;
import br.com.jkavdev.groups.event.RecursoCriadoEvent;
import br.com.jkavdev.groups.utils.ServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/noticias")
public class NoticiaController implements ServiceMap {

    @Autowired
    private NoticiaService noticiaService;
    @Autowired
    private GrupoService grupoService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/topicos")
    public Topico[] topicos() {
        return Topico.values();
    }

    @PostMapping
    public ResponseEntity<NoticiaDTO> salvar(@RequestBody @Valid NoticiaDTO noticia, HttpServletResponse response) {
        Noticia noticiaSalva = noticiaService.salvar(Noticia.from(noticia));
        noticia.setId(noticiaSalva.getId());
        publisher.publishEvent(new RecursoCriadoEvent(this, response, noticiaSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(noticia);
    }

    @PutMapping
    public ResponseEntity<NoticiaDTO> atualizar(@RequestBody @Valid NoticiaDTO noticia, HttpServletResponse response) {
        noticiaService.atualizar(Noticia.from(noticia));
        return ResponseEntity.ok(noticia);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable @Valid @NotNull Long id) {
        noticiaService.remover(id);
    }

    @GetMapping("/agrupadas")
    public List<GrupoDTO> agrupadas() {
        return grupoService.gruposComNoticias().stream()
                .map(g -> GrupoDTO.comNoticias(g))
                .collect(toList());
    }

    @PutMapping("{id}/marcar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void marcar(@PathVariable @Valid @NotNull Long id, @RequestBody Boolean util) {
        noticiaService.marcar(id, util);
    }

}
