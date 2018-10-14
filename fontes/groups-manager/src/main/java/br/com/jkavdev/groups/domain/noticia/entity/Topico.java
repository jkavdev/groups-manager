package br.com.jkavdev.groups.domain.noticia.entity;

import br.com.jkavdev.groups.domain.noticia.controller.TopicoJsonDeserializer;
import br.com.jkavdev.groups.domain.noticia.controller.TopicoJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Map;
import java.util.Optional;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

@JsonSerialize(using = TopicoJsonSerializer.class)
@JsonDeserialize(using = TopicoJsonDeserializer.class)
public enum Topico {

    MUNDO("Mundo"),
    NEGOCIOS("Negócios"),
    CIENCIA_TECNOLOGIA("Ciencia/Tecnologia"),
    ENTRETERIMENTO("Entreterimento"),
    ESPORTE("Esporte"),
    SAUDE("Saúde"),
    OUTROS("Outros");

    private static Map<String, Topico> namesMap;

    static {
        namesMap = of(Topico.values())
                .collect(toMap(Topico::name, identity()));
    }

    public static Optional<Topico> forValue(String value) {
        return Optional.ofNullable(namesMap.get(value));
    }

    private String descricao;

    Topico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
