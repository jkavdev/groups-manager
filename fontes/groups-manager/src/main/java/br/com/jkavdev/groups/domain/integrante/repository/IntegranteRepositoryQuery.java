package br.com.jkavdev.groups.domain.integrante.repository;

import br.com.jkavdev.groups.domain.integrante.dto.GruposIntegrantesDTO;

import java.util.List;

public interface IntegranteRepositoryQuery {

	List<GruposIntegrantesDTO> filtrar(IntegranteFilter filter);

}
