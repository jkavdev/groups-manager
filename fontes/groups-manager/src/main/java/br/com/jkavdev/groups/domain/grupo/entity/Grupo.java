package br.com.jkavdev.groups.domain.grupo.entity;

import br.com.jkavdev.groups.domain.evento.entity.Evento;
import br.com.jkavdev.groups.domain.grupo.dto.GrupoDTO;
import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
import br.com.jkavdev.groups.domain.noticia.entity.Noticia;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String objetivo;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "igreja_id", foreignKey = @ForeignKey(name = "fk_grupo_igreja_id"))
    private Igreja igreja;

    @Column(name = "status_grupo_id", nullable = false)
    private Long statusGrupoId;

    @ManyToMany
    @JoinTable(
            name = "grupo_integrante",
            joinColumns = @JoinColumn(name = "grupo_id"), foreignKey = @ForeignKey(name = "fk_grupo_integrante_grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "integrante_id"), inverseForeignKey = @ForeignKey(name = "fk_grupo_integrante_integrante_id"))
    private Collection<Integrante> integrantes = new HashSet<>();

    @OneToMany(mappedBy = "grupo")
    private Collection<Evento> eventos = new HashSet<>();

    @OneToMany(mappedBy = "grupo")
    private Collection<Noticia> noticias = new HashSet<>();

    private Grupo() {
    }

    public Grupo(Long id) {
        this.id = id;
    }

    public Grupo(String nome, String objetivo, String igreja, Long statusId) {
        statusGrupoId = StatusGrupo.idValidado(statusId);
        this.nome = nome;
        this.objetivo = objetivo;
        this.igreja = new Igreja(igreja);
        this.statusGrupoId = statusId;
    }

    public static Grupo from(GrupoDTO dto) {
        return new Grupo(dto.getNome(), dto.getObjetivo(), dto.getIgreja(), dto.getStatusGrupoId());
    }

    public static Grupo from(Long id) {
        return new Grupo(id);
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

    public Igreja getIgreja() {
        return igreja;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public Long getStatusGrupoId() {
        return statusGrupoId;
    }

    public Collection<Integrante> getIntegrantes() {
        return Collections.unmodifiableCollection(integrantes);
    }

    public Collection<Evento> getEventos() {
        return eventos;
    }

    public Collection<Noticia> getNoticias() {
        return noticias;
    }

    public void adicionar(Integrante integrante) {
        Objects.requireNonNull(integrante);
        integrantes.add(integrante);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("nome", nome)
                .append("objetivo", objetivo)
                .toString();
    }
}
