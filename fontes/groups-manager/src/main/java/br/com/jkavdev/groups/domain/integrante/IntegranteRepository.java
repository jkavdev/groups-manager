package br.com.jkavdev.groups.domain.integrante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegranteRepository extends JpaRepository<Integrante, Long>, IntegranteRepositoryQuery {

}
