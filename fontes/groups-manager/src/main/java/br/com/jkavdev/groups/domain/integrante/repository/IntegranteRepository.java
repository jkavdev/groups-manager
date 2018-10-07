package br.com.jkavdev.groups.domain.integrante.repository;

import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IntegranteRepository extends JpaRepository<Integrante, Long>, IntegranteRepositoryQuery {

    @Query("SELECT i FROM Integrante i LEFT JOIN FETCH i.grupos g WHERE i.id = :id")
    Integrante integrantesComGrupos(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM grupo_integrante WHERE integrante_id = :id")
    void removeGruposIntegrantes(@Param("id") Long id);
}
