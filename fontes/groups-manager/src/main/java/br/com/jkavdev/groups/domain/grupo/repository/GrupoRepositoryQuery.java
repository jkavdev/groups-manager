package br.com.jkavdev.groups.domain.grupo.repository;

import br.com.jkavdev.groups.domain.grupo.entity.Grupo;

import java.util.List;

public interface GrupoRepositoryQuery {

	List<Grupo> filtrar(GrupoFilter filter);

}
