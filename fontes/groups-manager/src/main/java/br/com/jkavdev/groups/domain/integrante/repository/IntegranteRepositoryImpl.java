package br.com.jkavdev.groups.domain.integrante.repository;

import br.com.jkavdev.groups.domain.integrante.dto.IntegranteDTO;
import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.hibernate.criterion.Projections.projectionList;
import static org.hibernate.criterion.Projections.property;
import static org.hibernate.transform.Transformers.aliasToBean;

public class IntegranteRepositoryImpl implements IntegranteRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings({"deprecation", "unchecked"})
    @Override
    public List<IntegranteDTO> filtrar(IntegranteFilter filter) {
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
                .add(property("integrante.id"), "id")
                .add(property("integrante.nome"), "nome")
                .add(property("integrante.idade"), "idade")
                .add(property("integrante.celular"), "celular")
                .add(property("integrante.senha"), "senha")
                .add(property("integrante.sexo"), "sexo")
                .add(property("integrante.dataNascimento"), "dataNascimento")
                .add(property("integrante.cpf"), "cpf")
                .add(property("integrante.cadastroEfetivado"), "cadastroEfetivado")
        ).setResultTransformer(aliasToBean(IntegranteDTO.class));

        return criteria.list();
    }

}
