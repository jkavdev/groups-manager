package br.com.jkavdev.groups.domain.evento.entity;

import br.com.jkavdev.groups.domain.evento.dto.EnderecoDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String unidade;

    @NotBlank
    private String localidade;

    @NotBlank
    private String bairro;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UF uf;

    @NotBlank
    private String cep;

    private String complemento;

    protected Endereco() {
    }

    public Endereco(Long id, String logradouro, String localidade, String unidade, UF uf, String cep, String bairro) {
        this.id = id;
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.unidade = unidade;
        this.uf = uf;
        this.cep = cep;
        this.bairro = bairro;
    }

    public static Endereco from(EnderecoDTO dto) {
        return new Endereco(dto.getId(), dto.getLogradouro(), dto.getLocalidade(), dto.getUnidade(),
                dto.getUf(), dto.getCep(), dto.getBairro());
    }

    public Long getId() {
        return id;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getUnidade() {
        return unidade;
    }

    public UF getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("logradouro", logradouro)
                .append("unidade", unidade)
                .append("bairro", bairro)
                .append("localidade", localidade)
                .append("uf", uf)
                .append("cep", cep)
                .append("complemento", complemento).build();
    }

}
