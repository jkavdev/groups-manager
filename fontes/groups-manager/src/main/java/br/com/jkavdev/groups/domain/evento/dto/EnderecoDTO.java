package br.com.jkavdev.groups.domain.evento.dto;

import br.com.jkavdev.groups.domain.evento.entity.UF;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnderecoDTO {

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
    private UF uf;
    @NotBlank
    private String cep;
    private String complemento;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Long id) {
        this.id = id;
    }

    public EnderecoDTO(String logradouro, String numero, String localidade, String unidade, UF uf, String cep, String bairro) {
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.unidade = unidade;
        this.uf = uf;
        this.cep = cep;
        this.bairro = bairro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("logradouro", logradouro)
                .append("unidade", unidade)
                .append("localidade", localidade)
                .append("bairro", bairro)
                .append("uf", uf)
                .append("cep", cep)
                .append("complemento", complemento)
                .toString();
    }
}
