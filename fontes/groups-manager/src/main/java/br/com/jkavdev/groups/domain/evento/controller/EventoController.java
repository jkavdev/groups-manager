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
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController implements ServiceMap {

    @Autowired
    private EventoService eventoService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity<EventoDTO> salvar(@Valid @RequestBody EventoDTO evento, HttpServletResponse response) {
        Evento eventoSalvo = eventoService.salvar(Evento.from(evento));
        publisher.publishEvent(new RecursoCriadoEvent(this, response, eventoSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(evento);
    }

    @GetMapping(params = "pesquisa")
    public List<EventoDTO> filtrar(EventoFilter filter) {
        return eventoService.filtrar(filter);
    }

    @GetMapping("/ufs")
    public UF[] ufs() {
        return UF.values();
    }

}
