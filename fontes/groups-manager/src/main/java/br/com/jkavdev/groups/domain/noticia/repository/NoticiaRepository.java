package br.com.jkavdev.groups.domain.noticia.repository;

import br.com.jkavdev.groups.domain.noticia.entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Noticia WHERE grupo_id = :id")
    void removeNoticiasDoGrupo(@Param("id") Long id);

    @Query("SELECT n FROM Noticia n LEFT JOIN FETCH n.informacaoUtil i WHERE n.id = :id")
    Optional<Noticia> comInformacoesUtil(@Param("id") Long id);

    @Query("SELECT n FROM Noticia n " +
            "INNER JOIN FETCH n.topicos t " +
            "INNER JOIN FETCH n.grupo g " +
            "WHERE n.id = :id")
    Optional<Noticia> comTodosDados(@Param("id") Long id);

}
