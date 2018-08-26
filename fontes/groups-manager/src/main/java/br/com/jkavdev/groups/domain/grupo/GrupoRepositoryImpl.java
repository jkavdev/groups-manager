package br.com.jkavdev.groups.domain.grupo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

public class GrupoRepositoryImpl implements GrupoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Grupo> filtrar(GrupoFilter filter) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Grupo.class);

		if (StringUtils.hasText(filter.getNome())) {
			criteria.add(Restrictions.ilike("nome", filter.getNome(), MatchMode.START));
		}

		/*
		 select g from Grupo g
		 where (:nome is null or (:nome is not null and g.nome = :nome) )
		 and (:igreja is null or (:igreja is not null and g.igreja = :igreja) )
		 * */

		return criteria.list();
	}

}
