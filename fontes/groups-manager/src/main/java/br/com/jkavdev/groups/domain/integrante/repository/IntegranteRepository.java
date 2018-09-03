package br.com.jkavdev.groups.domain.integrante.repository;

import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegranteRepository extends JpaRepository<Integrante, Long>, IntegranteRepositoryQuery {

}
