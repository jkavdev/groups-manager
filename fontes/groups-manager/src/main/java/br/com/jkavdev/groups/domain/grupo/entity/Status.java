package br.com.jkavdev.groups.domain.grupo.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Collection;

//Apenas para gerar o ddl com o hibernate

@Entity
@Table(name = "status_grupo")
@Immutable
public class Status {

    @Id
    private Long id;

    @Column(length = 20)
    private String nome;

    private String descricao;

    @OneToMany(mappedBy = "statusGrupo")
    private Collection<Grupo> grupos;

    protected Status() {
    }

}
