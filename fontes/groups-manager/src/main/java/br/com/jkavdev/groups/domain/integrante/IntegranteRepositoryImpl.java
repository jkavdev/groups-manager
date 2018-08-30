package br.com.jkavdev.groups.domain.integrante;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hibernate.criterion.Projections.*;
import static org.hibernate.transform.Transformers.aliasToBean;

public class IntegranteRepositoryImpl implements IntegranteRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings({"deprecation", "unchecked"})
    @Override
    public List<GruposIntegrantesDTO> filtrar(IntegranteFilter filter) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Integrante.class, "integrante");
        criteria.createAlias("integrante.grupos", "grupo");

        if (StringUtils.hasText(filter.getNome())) {
            criteria.add(Restrictions.ilike("integrante.nome", filter.getNome(), MatchMode.ANYWHERE));
        }
        if (StringUtils.hasText(filter.getGrupo())) {
            criteria.add(Restrictions.ilike("grupo.nome", filter.getNome(), MatchMode.ANYWHERE));
        }

        criteria.setProjection(projectionList()
                .add(groupProperty("grupo.nome"))
                .add(property("grupo.nome"), "grupo")
                .add(property("integrante.nome"), "integrante")
        ).setResultTransformer(aliasToBean(GruposIntegrantesDTO.class));

        List<GruposIntegrantesDTO> integrantesPorGrupo = criteria.list();

        Map<String, List<GruposIntegrantesDTO>> collect = integrantesPorGrupo.stream()
                .collect(Collectors.groupingBy(GruposIntegrantesDTO::getGrupo));

        return integrantesPorGrupo;
    }

}
