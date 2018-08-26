package br.com.jkavdev.groups.domain.grupo;

import java.util.List;

public interface GrupoRepositoryQuery {

	List<Grupo> filtrar(GrupoFilter filter);

}
