package br.com.jkavdev.groups.domain.grupo.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
