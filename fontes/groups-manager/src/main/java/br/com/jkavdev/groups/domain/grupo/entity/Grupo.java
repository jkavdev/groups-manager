package br.com.jkavdev.groups.domain.grupo.entity;

import br.com.jkavdev.groups.domain.evento.entity.Evento;
import br.com.jkavdev.groups.domain.grupo.dto.GrupoDTO;
import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
import br.com.jkavdev.groups.domain.noticia.entity.Noticia;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 100)
    private String nome;

    @NotBlank
    private String objetivo;

    @Column(name = "igreja_id", nullable = false)
    private Long igrejaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "igreja_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_grupo_igreja_id"))
    private Igreja igreja;

    @Column(name = "status_grupo_id", nullable = false)
    private Long statusGrupoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_grupo_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_grupo_status_grupo_id"))
    private Status statusGrupo;

    @ManyToMany
    @JoinTable(
            name = "grupo_integrante",
            joinColumns = @JoinColumn(name = "grupo_id"), foreignKey = @ForeignKey(name = "fk_grupo_integrante_grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "integrante_id"), inverseForeignKey = @ForeignKey(name = "fk_grupo_integrante_integrante_id"))
    private Set<Integrante> integrantes = new HashSet<>();

    @OneToMany(mappedBy = "grupo")
    private Set<Evento> eventos = new HashSet<>();

    @OneToMany(mappedBy = "grupo")
    private Set<Noticia> noticias = new HashSet<>();

    public Grupo() {
    }

    public Grupo(Long id) {
        this.id = id;
    }

    public Grupo(Long id, String nome, String objetivo, Long statusId) {
        this.id = id;
        this.statusGrupoId = StatusGrupo.idValidado(statusId);
        this.nome = nome;
        this.objetivo = objetivo;
        this.igrejaId = Igrejas.MENINO_DEUS.getId();
    }

    public static Grupo from(GrupoDTO dto) {
        return new Grupo(dto.getId(), dto.getNome(), dto.getObjetivo(), dto.getStatusGrupoId());
    }

    public static Grupo from(Long id) {
        return new Grupo(id);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Long getStatusGrupoId() {
        return statusGrupoId;
    }

    public void setStatusGrupoId(Long statusGrupoId) {
        this.statusGrupoId = statusGrupoId;
    }

    public Set<Integrante> getIntegrantes() {
        return Collections.unmodifiableSet(integrantes);
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public Set<Noticia> getNoticias() {
        return noticias;
    }

    public void adicionar(Integrante integrante) {
        Objects.requireNonNull(integrante);
        integrantes.add(integrante);
    }

    public void adicionar(Collection<Integrante> integrantes) {
        Objects.requireNonNull(integrantes);
        this.integrantes = new HashSet<>(integrantes);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("nome", nome)
                .append("objetivo", objetivo)
                .append("igreja", Igrejas.MENINO_DEUS.getIgreja())
                .append("status", StatusGrupo.from(statusGrupoId))
                .toString();
    }

    public void atualizarDadosBasicos(Grupo grupo) {
        this.setObjetivo(grupo.getObjetivo());
        this.setNome(grupo.getNome());
        this.setStatusGrupoId(grupo.statusGrupoId);
    }
}
