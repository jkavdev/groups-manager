package br.com.jkavdev.groups.domain.evento.service;

import br.com.jkavdev.groups.domain.evento.dto.EventoDTO;
import br.com.jkavdev.groups.domain.evento.entity.Evento;
import br.com.jkavdev.groups.domain.evento.repository.EventoFilter;
import br.com.jkavdev.groups.domain.evento.repository.EventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Evento buscarPor(Long id) {
        Optional<Evento> evento = eventoRepository.buscarPor(id);
        evento.orElseThrow(() -> new EmptyResultDataAccessException(1));
        return evento.get();
    }

    public void atualizar(Long id, Evento evento) {
        Evento eventoSalvo = buscarPor(id);
        BeanUtils.copyProperties(evento, eventoSalvo, "id");
        eventoRepository.save(eventoSalvo);
    }

}
