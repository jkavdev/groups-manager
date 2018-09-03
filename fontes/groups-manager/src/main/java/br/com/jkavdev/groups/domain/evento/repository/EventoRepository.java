package br.com.jkavdev.groups.domain.evento.repository;

import br.com.jkavdev.groups.domain.evento.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long>, EventoRepositoryQuery {

}
