package br.com.jkavdev.groups.domain.evento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long>, EventoRepositoryQuery {

}
