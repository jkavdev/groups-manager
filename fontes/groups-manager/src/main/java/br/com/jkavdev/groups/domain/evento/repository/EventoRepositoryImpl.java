package br.com.jkavdev.groups.domain.evento.repository;

import br.com.jkavdev.groups.domain.evento.dto.EventoDTO;
import br.com.jkavdev.groups.domain.evento.entity.Evento;
import br.com.jkavdev.groups.domain.evento.entity.Evento_;
import br.com.jkavdev.groups.utils.RootRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class EventoRepositoryImpl extends RootRepository implements EventoRepositoryQuery {

    @Override
    public List<EventoDTO> filtrar(EventoFilter filter) {
        CriteriaQuery<EventoDTO> cq = cb().createQuery(EventoDTO.class);
        Root<Evento> eventoRoot = cq.from(Evento.class);

        List<Predicate> pd = new ArrayList<>();
        if (nonNull(filter.getDe()) && isNull(filter.getAte())) {
            pd.add(cb().greaterThanOrEqualTo(eventoRoot.get(Evento_.data), filter.getDe()));
        }
        if (nonNull(filter.getAte()) && isNull(filter.getDe())) {
            pd.add(cb().lessThanOrEqualTo(eventoRoot.get(Evento_.data), filter.getAte()));
        }
        if (nonNull(filter.getDe()) && nonNull(filter.getAte())) {
            pd.add(cb().between(eventoRoot.get(Evento_.data), filter.getDe(), filter.getAte()));
        }

        cq.select(cb().construct(EventoDTO.class,
                eventoRoot.get(Evento_.id),
                eventoRoot.get(Evento_.data),
                eventoRoot.get(Evento_.descricao),
                eventoRoot.get(Evento_.objetivo),
                eventoRoot.get(Evento_.valor)
        )).where(pd.toArray(new Predicate[]{}));

        return manager().createQuery(cq).getResultList();
    }
}
