package br.com.jkavdev.groups.domain.grupo.entity;

import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public enum StatusGrupo {

    PASTORAL_DO_DIZIMO("PASTORAIS", "Pastoral do Dizimo", "descricao", 1L),
    PASTORAL_FAMILIAR("PASTORAIS", "Pastoral Familiar", "descricao", 2L),
    PASTORAL_DA_CRIANÇA("PASTORAIS", "Pastoral da Criança", "descricao", 3L),
    VICENTINOS("PASTORAIS", "Vicentinos", "descricao", 4L),
    GAM("MOVIMENTO", "GAM", "descricao", 5L),
    EJOC("MOVIMENTO", "EJOC", "descricao", 6L),
    AJUC("MOVIMENTO", "AJUC", "descricao", 7L);

    public static final Map<Long, StatusGrupo> statuses = Stream.of(StatusGrupo.values())
            .collect(toMap(StatusGrupo::getId, Function.identity()));

    private final String status;
    private final String nome;
    private final String descricao;
    private final Long id;

    StatusGrupo(String status, String nome, String descricao, Long id) {
        this.status = status;
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
    }

    public static Long idValidado(Long statusId) {
        Optional<StatusGrupo> grupo = Optional.ofNullable(statuses.get(statusId));
        grupo.orElseThrow(() -> new EmptyResultDataAccessException(0));
        return grupo.get().getId();
    }

    public static StatusGrupo from(Long id) {
        return statuses.get(id);
    }

    public String getStatus() {
        return status;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getId() {
        return id;
    }

}
