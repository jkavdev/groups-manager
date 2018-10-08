package br.com.jkavdev.groups.domain.evento.controller;

import br.com.jkavdev.groups.domain.evento.dto.EventoDTO;
import br.com.jkavdev.groups.domain.evento.entity.Evento;
import br.com.jkavdev.groups.domain.evento.entity.UF;
import br.com.jkavdev.groups.domain.evento.repository.EventoFilter;
import br.com.jkavdev.groups.domain.evento.service.EventoService;
import br.com.jkavdev.groups.event.RecursoCriadoEvent;
import br.com.jkavdev.groups.utils.ServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/eventos")
public class EventoController implements ServiceMap {

    @Autowired
    private EventoService eventoService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping(params = "pesquisa")
    public List<EventoDTO> filtrar(EventoFilter filter) {
        return eventoService.filtrar(filter);
    }

    @GetMapping("{id}")
    public EventoDTO buscarPor(@PathVariable("id") Long id) {
        return EventoDTO.from(eventoService.buscarPor(id));
    }

    @GetMapping("/ufs")
    public UF[] ufs() {
        return UF.values();
    }

    @PostMapping
    public ResponseEntity<EventoDTO> salvar(@Valid @RequestBody EventoDTO evento, HttpServletResponse response) {
        Evento eventoSalvo = eventoService.salvar(Evento.from(evento));
        publisher.publishEvent(new RecursoCriadoEvent(this, response, eventoSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EventoDTO dto) {
        eventoService.atualizar(id, Evento.from(dto));
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void remover(@PathVariable("id") Long id) {
        eventoService.remover(id);
    }

}
