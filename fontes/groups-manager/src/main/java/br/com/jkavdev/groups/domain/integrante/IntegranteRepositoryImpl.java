package br.com.jkavdev.groups.domain.integrante;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

public class IntegranteRepositoryImpl implements IntegranteRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Integrante> filtrar(IntegranteFilter filter) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Integrante.class);

		if (StringUtils.hasText(filter.getNome())) {
			criteria.add(Restrictions.ilike("nome", filter.getNome(), MatchMode.START));
		}
//		if (StringUtils.hasText(filter.getGrupo())) {
//			criteria.add(Restrictions.ilike("nome", filter.getNome(), MatchMode.START));
//		}

		return criteria.list();
	}

}
