package br.com.jkavdev.groups.domain.grupo.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.result.NoMoreReturnsException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Igreja {

    private static final String NOME = "Pastoral";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome = NOME;

    private Igreja() {
    }

    public Igreja(String nome) {
        this.nome = nome;
    }

    public static Igreja PASTORAL() {
        return new Igreja(NOME);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Igreja igreja = (Igreja) o;
        return Objects.equals(nome.toUpperCase(), igreja.nome.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toUpperCase());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("nome", nome)
                .toString();
    }
}