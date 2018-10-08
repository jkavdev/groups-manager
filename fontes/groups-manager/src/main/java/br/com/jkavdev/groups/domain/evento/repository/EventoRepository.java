package br.com.jkavdev.groups.domain.evento.repository;

import br.com.jkavdev.groups.domain.evento.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Long>, EventoRepositoryQuery {

    @Query("SELECT e FROM Evento e JOIN FETCH e.endereco en WHERE e.id = :id")
    Optional<Evento> buscarPor(@Param("id") Long id);

}
