package br.com.jkavdev.groups.domain.noticia.repository;

import br.com.jkavdev.groups.domain.noticia.entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

}
