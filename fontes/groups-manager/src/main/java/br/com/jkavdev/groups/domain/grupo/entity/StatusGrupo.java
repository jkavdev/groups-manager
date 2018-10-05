package br.com.jkavdev.groups.domain.grupo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusGrupo {

    MOVIMENTO("MOVIMENTO", "Movimento", "São grupos específico com organização específica muitas vezes independente.",
            2L, "MOVIMENTO"),
    PASTORAIS("PASTORAL", "Pastoral", "Projeto de evangelização que é distribuído a vários grupos em diferentes setores.",
            1L, "PASTORAL"),
    GRUPO("GRUPO", "Grupo", "Formados por fiéis, que se reúnem de forma espontânea, porém sempre com a licença e orientação do pároco ou vigário paroquial e tendo como base a oração e a escuta da Palavra.",
            3L, "GRUPO");

    public static final Map<Long, StatusGrupo> statuses =
            Stream.of(StatusGrupo.values())
                    .collect(toMap(StatusGrupo::getId, identity()));

    private final String status;
    private final String nome;
    private final String descricao;
    private final Long id;
    private final String imageName;

    StatusGrupo(String status, String nome, String descricao, Long id, String imageName) {
        this.status = status;
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
        this.imageName = imageName;
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

    public String getImageName() {
        return imageName;
    }
}
