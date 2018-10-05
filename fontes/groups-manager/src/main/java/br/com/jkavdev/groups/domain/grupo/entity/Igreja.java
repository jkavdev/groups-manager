package br.com.jkavdev.groups.domain.grupo.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Collection;

//Apenas para gerar o ddl com o hibernate

@Entity
@Immutable
public class Igreja {

    @Id
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "igreja")
    private Collection<Grupo> grupos;

    protected Igreja(){}

    public Igreja(Long id) {
        this.id = id;
    }
}