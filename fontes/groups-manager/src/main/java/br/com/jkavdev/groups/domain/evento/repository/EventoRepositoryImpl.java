package br.com.jkavdev.groups.domain.evento.repository;

import br.com.jkavdev.groups.domain.evento.dto.EventoDTO;
import br.com.jkavdev.groups.domain.evento.entity.Evento;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.hibernate.criterion.Projections.property;
import static org.hibernate.criterion.Restrictions.*;

public class EventoRepositoryImpl implements EventoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings({"deprecation", "unchecked"})
    @Override
    public List<EventoDTO> filtrar(EventoFilter filter) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Evento.class);

        if (nonNull(filter.getDe()) && isNull(filter.getAte())) {
            criteria.add(ge("data", filter.getDe()));
        }
        if (nonNull(filter.getAte()) && isNull(filter.getDe())) {
            criteria.add(le("data", filter.getAte()));
        }
        if (nonNull(filter.getDe()) && nonNull(filter.getAte())) {
            criteria.add(between("data", filter.getDe(), filter.getAte()));
        }

        criteria.setProjection(Projections.projectionList()
                .add(property("id"), "id")
                .add(property("data"), "data")
                .add(property("descricao"), "descricao")
                .add(property("objetivo"), "objetivo")
                .add(property("valor"), "valor"));

        return criteria
                .setResultTransformer(Transformers.aliasToBean(EventoDTO.class))
                .list();
    }

}
