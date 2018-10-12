package br.com.jkavdev.groups.domain.integrante.repository;

import br.com.jkavdev.groups.domain.grupo.entity.Grupo;
import br.com.jkavdev.groups.domain.grupo.entity.Grupo_;
import br.com.jkavdev.groups.domain.integrante.dto.IntegranteDTO;
import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
import br.com.jkavdev.groups.domain.integrante.entity.Integrante_;
import br.com.jkavdev.groups.utils.RootRepository;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

public class IntegranteRepositoryImpl extends RootRepository implements IntegranteRepositoryQuery {

    @Override
    public List<IntegranteDTO> filtrar(IntegranteFilter filter) {

        CriteriaQuery<IntegranteDTO> cq = cb().createQuery(IntegranteDTO.class);
        Root<Integrante> integranteRoot = cq.from(Integrante.class);

        List<Predicate> pd = new ArrayList<>();
        if (hasText(filter.getNome())) {
            pd.add(cb().like(integranteRoot.get(Integrante_.nome), "%" + filter.getNome() + "%"));
        }
        if (hasText(filter.getGrupo())) {
            Join<Integrante, Grupo> grupoRoot = integranteRoot.join(Integrante_.grupos, JoinType.INNER);
            pd.add(cb().like(grupoRoot.get(Grupo_.nome), "%" + filter.getGrupo() + "%"));
        }

        cq
                .select(cb().construct(IntegranteDTO.class,
                        integranteRoot.get(Integrante_.id),
                        integranteRoot.get(Integrante_.nome),
                        integranteRoot.get(Integrante_.idade),
                        integranteRoot.get(Integrante_.celular),
                        integranteRoot.get(Integrante_.sexo),
                        integranteRoot.get(Integrante_.email),
                        integranteRoot.get(Integrante_.dataNascimento),
                        integranteRoot.get(Integrante_.cpf),
                        integranteRoot.get(Integrante_.cadastroEfetivado)
                ))
                .where(pd.toArray(new Predicate[]{}))
                .groupBy(integranteRoot.get(Integrante_.id));

        return manager().createQuery(cq).getResultList();
    }

}
