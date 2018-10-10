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

    PASTORAL("PASTORAL", "Pastoral", "Pastoral, é serviço, ação, trabalho desenvolvido pela Igreja. " +
            "Ação organizada e dirigida pela Diocese e Paróquia para “atender” determinada situação em uma " +
            "realidade específica.", 1L),
    MOVIMENTO("MOVIMENTO", "Movimento", "Movimento, são grupos específico com organização específica muitas vezes " +
            "independente, não diretamente ligados a uma paróquia. Os movimentos nascem e se formam num contexto " +
            "externo à igreja local, mas atuam dentro da Paróquia.", 2L),
    GRUPO("GRUPO", "Grupo", "Grupo, é formados por fiéis, que se reúnem de forma espontânea, porém sempre com a " +
            "licença e orientação do pároco ou vigário paroquial e tendo como base a oração e a escuta da Palavra.",
            3L);

    public static final Map<Long, StatusGrupo> statuses =
            Stream.of(StatusGrupo.values())
                    .collect(toMap(StatusGrupo::getId, identity()));

    private final Long id;
    private final String status;
    private final String nome;
    private final String descricao;

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

    public Long getId() {
        return id;
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

}
