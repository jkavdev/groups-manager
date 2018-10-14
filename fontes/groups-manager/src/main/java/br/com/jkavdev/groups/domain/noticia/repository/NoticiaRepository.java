package br.com.jkavdev.groups.domain.noticia.repository;

import br.com.jkavdev.groups.domain.noticia.entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Noticia WHERE grupo_id = :id")
    void removeNoticiasDoGrupo(@Param("id") Long id);

}
