package br.com.jkavdev.groups.domain.grupo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class StatusGrupoDTO {

    private Long id;
    private String nome;

    public StatusGrupoDTO() {
    }

    public StatusGrupoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static StatusGrupoDTO from(StatusGrupo g) {
        return new StatusGrupoDTO(g.getId(), g.getNome());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("nome", nome)
                .toString();
    }
}
