package br.com.jkavdev.groups.domain.integrante.repository;

import br.com.jkavdev.groups.domain.grupo.entity.Grupo;
import br.com.jkavdev.groups.domain.integrante.dto.IntegranteDTO;
import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
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
            pd.add(cb().like(integranteRoot.get("nome"), "%" + filter.getNome() + "%"));
        }
        if (hasText(filter.getGrupo())) {
            Join<Integrante, Grupo> grupoRoot = integranteRoot.join("grupos", JoinType.INNER);
            pd.add(cb().like(grupoRoot.get("nome"), "%" + filter.getGrupo() + "%"));
        }

        cq
                .select(cb().construct(IntegranteDTO.class,
                        integranteRoot.get("id"),
                        integranteRoot.get("nome"),
                        integranteRoot.get("idade"),
                        integranteRoot.get("celular"),
                        integranteRoot.get("sexo"),
                        integranteRoot.get("email"),
                        integranteRoot.get("dataNascimento"),
                        integranteRoot.get("cpf"),
                        integranteRoot.get("cadastroEfetivado")
                ))
                .where(pd.toArray(new Predicate[]{}))
                .groupBy(integranteRoot.get("id"));

        return manager().createQuery(cq).getResultList();
    }

}
