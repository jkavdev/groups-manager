package br.com.jkavdev.groups.domain.evento.service;

import java.util.List;

import br.com.jkavdev.groups.domain.evento.dto.EventoDTO;
import br.com.jkavdev.groups.domain.evento.entity.Evento;
import br.com.jkavdev.groups.domain.evento.repository.EventoFilter;
import br.com.jkavdev.groups.domain.evento.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	public Evento salvar(Evento evento) {
		return eventoRepository.save(evento);
	}

	public List<EventoDTO> filtrar(EventoFilter filter) {
		return eventoRepository.filtrar(filter);
	}

}
