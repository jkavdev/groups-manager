package br.com.jkavdev.groups.domain.evento;

import br.com.jkavdev.groups.domain.evento.dto.EventoDTO;

import java.util.List;

public interface EventoRepositoryQuery {

    List<EventoDTO> filtrar(EventoFilter filter);

}
