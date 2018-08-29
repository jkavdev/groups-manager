package br.com.jkavdev.groups.domain.grupo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class GrupoFilter {

    private String nome;
    private String objetivo;
    private Igreja igreja;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .append("objetivo", objetivo)
                .append("igreja", igreja)
                .toString();
    }
}
