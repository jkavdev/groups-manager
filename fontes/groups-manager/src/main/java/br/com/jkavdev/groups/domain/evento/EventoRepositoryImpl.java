package br.com.jkavdev.groups.domain.evento;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.jkavdev.groups.domain.evento.dto.EventoDTO;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import static java.util.Objects.*;

public class EventoRepositoryImpl implements EventoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings({"deprecation", "unchecked"})
    @Override
    public List<EventoDTO> filtrar(EventoFilter filter) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Evento.class);

        if (nonNull(filter.getDe()) && isNull(filter.getAte())) {
            criteria.add(Restrictions.ge("data", filter.getDe()));
        }
        if (nonNull(filter.getAte()) && isNull(filter.getDe())) {
            criteria.add(Restrictions.le("data", filter.getAte()));
        }
        if (nonNull(filter.getDe()) && nonNull(filter.getAte())) {
            criteria.add(Restrictions.between("data", filter.getDe(), filter.getAte()));
        }

        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("id"), "id")
                .add(Projections.property("data"), "data")
                .add(Projections.property("descricao"), "descricao")
                .add(Projections.property("objetivo"), "objetivo")
                .add(Projections.property("valor"), "valor"));

        return criteria
                .setResultTransformer(Transformers.aliasToBean(EventoDTO.class))
                .list();
    }

}
