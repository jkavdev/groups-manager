package br.com.jkavdev.groups.domain.grupo.repository;

import br.com.jkavdev.groups.domain.grupo.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GrupoRepository extends JpaRepository<Grupo, Long>, GrupoRepositoryQuery {

    @Query("SELECT COUNT(g) FROM Grupo g JOIN g.integrantes WHERE g.id = ?1")
    Long countByIntegrantes(Long id);

    @Query(nativeQuery = true, value = "SELECT COUNT(g.grupo_id) FROM Grupo_integrante g WHERE g.grupo_id = ?1")
    Long countByIntegrantesSQL(Long id);

    @Query("SELECT DISTINCT g FROM Grupo g JOIN FETCH g.noticias n JOIN FETCH n.topicos t")
    List<Grupo> gruposComNoticias();

    @Query("SELECT g FROM Grupo g " +
            "LEFT JOIN FETCH g.eventos e " +
            "LEFT JOIN FETCH g.noticias n " +
            "LEFT JOIN FETCH n.topicos t " +
            "WHERE g.id = ?1")
    Grupo grupoTodosDados(Long id);

    @Query("SELECT g FROM Grupo g LEFT JOIN FETCH g.integrantes inte WHERE g.id = ?1")
    Optional<Grupo> findByIdFetchIntegrantes(Long idGrupo);

    @Query("SELECT DISTINCT g FROM Grupo g LEFT JOIN FETCH g.integrantes inte")
    List<Grupo> gruposComIntegrantes();

    @Query("SELECT g FROM Grupo g LEFT JOIN FETCH g.eventos e LEFT JOIN FETCH e.endereco inte WHERE g.id = ?1")
    Optional<Grupo> findByIdFetchEventos(Long idGrupo);

}
