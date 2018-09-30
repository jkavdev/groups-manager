package br.com.jkavdev.groups.domain.grupo.repository;

import br.com.jkavdev.groups.domain.grupo.entity.Grupo;
import br.com.jkavdev.groups.utils.RootRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static javax.persistence.criteria.JoinType.INNER;
import static org.springframework.util.StringUtils.hasText;

public class GrupoRepositoryImpl extends RootRepository implements GrupoRepositoryQuery {


    @Override
    public List<Grupo> filtrar(GrupoFilter filter) {
        CriteriaQuery<Grupo> cq = cb().createQuery(Grupo.class);
        Root<Grupo> grupoRoot = cq.from(Grupo.class);

        grupoRoot.join("igreja", INNER);
        grupoRoot.join("statusGrupo", INNER);

        if (hasText(filter.getNome())) {
            cq.where(cb().like(grupoRoot.get("nome"), "%" + filter.getNome() + "%"));
        }

		/*
		 select g from Grupo g
		 where (:nome is null or (:nome is not null and g.nome = :nome) )
		 and (:igreja is null or (:igreja is not null and g.igreja = :igreja) )
		 * */

        return manager().createQuery(cq).getResultList();
    }
}
