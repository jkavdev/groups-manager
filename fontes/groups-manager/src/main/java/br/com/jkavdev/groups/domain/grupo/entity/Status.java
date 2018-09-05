package br.com.jkavdev.groups.domain.grupo.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name = "status_grupo")
@Immutable
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String status;

    private String descricao;

}
