package br.com.jkavdev.groups.domain.integrante.repository;

import br.com.jkavdev.groups.domain.integrante.dto.IntegranteDTO;

import java.util.List;

public interface IntegranteRepositoryQuery {

    List<IntegranteDTO> filtrar(IntegranteFilter filter);

}
