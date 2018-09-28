package br.com.jkavdev.groups.domain.grupo.repository;

import br.com.jkavdev.groups.domain.grupo.entity.Grupo;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GrupoRepositoryImpl implements GrupoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings({"deprecation", "unchecked"})
    @Override
    public List<Grupo> filtrar(GrupoFilter filter) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Grupo.class);
        criteria.setFetchMode("igreja", FetchMode.JOIN);
        criteria.setFetchMode("statusGrupo", FetchMode.JOIN);

        if (StringUtils.hasText(filter.getNome())) {
            criteria.add(Restrictions.ilike("nome", filter.getNome(), MatchMode.ANYWHERE));
        }

		/*
		 select g from Grupo g
		 where (:nome is null or (:nome is not null and g.nome = :nome) )
		 and (:igreja is null or (:igreja is not null and g.igreja = :igreja) )
		 * */

        return criteria.list();
    }


//    @Override
//    public List<Grupo> filtrar(GrupoFilter filter) {
//
//        CriteriaBuilder cb = manager.getCriteriaBuilder();
//        CriteriaQuery<Grupo> cq = cb.createQuery(Grupo.class);
//
//        Root<Grupo> grupoRoot = cq.from(Grupo.class);
////        grupoRoot.join("igreja", INNER);
//        grupoRoot.join("statusGrupo", INNER);
//
//        if (hasText(filter.getNome())) {
//            cb.like(grupoRoot.get("nome"), filter.getNome());
//        }
//
//        TypedQuery<Grupo> query = manager.createQuery(cq);
//
//        return query.getResultList();
//    }
}
