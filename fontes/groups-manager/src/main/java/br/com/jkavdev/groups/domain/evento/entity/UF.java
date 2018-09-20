package br.com.jkavdev.groups.domain.evento.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
//caso queiramos montar um enum UF
//@JsonDeserialize(using = EventoJsonDeserializer.class)
public enum UF {

    AC("AC", "Acre"),
    AL("AL", "Alagoas"),
    AP("AP", "Amapá"),
    AM("AM", "Amazonas"),
    BA("BA", "Bahia"),
    CE("CE", "Ceará"),
    DF("DF", "Distrito Federal"),
    ES("ES", "Espírito Santo"),
    GO("GO", "Goiás"),
    MA("MA", "Maranhão"),
    MT("MT", "Mato Grosso"),
    MS("MS", "Mato Grosso do Sul"),
    MG("MG", "Minas Gerais"),
    PA("PA", "Pará"),
    PB("PB", "Paraíba"),
    PR("PR", "Paraná"),
    PE("PE", "Pernambuco"),
    PI("PI", "Piauí"),
    RJ("RJ", "Rio de Janeiro"),
    RN("RN", "Rio Grande do Norte"),
    RS("RS", "Rio Grande do Sul"),
    RO("RO", "Rondônia"),
    RR("RR", "Roraima"),
    SC("SC", "Santa Catarina"),
    SP("SP", "São Paulo"),
    SE("SE", "Sergipe"),
    TO("TO", "Tocantins");

    private static Map<String, UF> namesMap;

    static {
        namesMap = of(UF.values())
                    .collect(toMap(UF::getSigla, identity()));
    }

    private final String descricao;
    private final String sigla;

    UF(String sigla, String descricao) {
        this.descricao = descricao;
        this.sigla = sigla;
    }

    @JsonCreator
    public static Optional<UF> forValue(String value) {
        return Optional.ofNullable(namesMap.get(value));
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getSigla() {
        return sigla;
    }
}
