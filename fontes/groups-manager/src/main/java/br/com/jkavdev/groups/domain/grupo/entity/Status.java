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

    private String nome;

    private String status;

    private String descricao;

    @OneToMany
    @JoinColumn(name = "status_grupo_id", foreignKey = @ForeignKey(name = "fk_grupo_status_grupo_id"))
    private Collection<Grupo> grupos;

}
