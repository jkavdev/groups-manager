package br.com.jkavdev.groups.domain.integrante;

import java.util.List;

public interface IntegranteRepositoryQuery {

	List<Integrante> filtrar(IntegranteFilter filter);

}
