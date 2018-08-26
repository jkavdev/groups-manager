package br.com.jkavdev.groups.domain.grupo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Igreja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Igreja() {
    }

    public Igreja(String nome) {
        this.nome = nome;
    }

    public static Igreja empty() {
        return new Igreja("");
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