package br.com.jkavdev.groups.domain.grupo;

import br.com.jkavdev.groups.domain.evento.Evento;
import br.com.jkavdev.groups.domain.integrante.Integrante;
import br.com.jkavdev.groups.domain.noticia.Noticia;
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
    @JoinColumn(name = "igreja_id")
    private Igreja igreja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_grupo_id")
    private StatusGrupo statusGrupo;

    @ManyToMany
    @JoinTable(
            name = "grupo_integrante",
            joinColumns = @JoinColumn(name = "grupo_id"), foreignKey = @ForeignKey(name = "fk_grupo_integrante_grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "integrante_id"), inverseForeignKey = @ForeignKey(name = "fk_integrante_id"))
    private Collection<Integrante> integrantes = new HashSet<>();

    @OneToMany(mappedBy = "grupo")
    private Collection<Evento> eventos = Collections.emptySet();

    @OneToMany(mappedBy = "grupo")
    private Collection<Noticia> noticias = Collections.emptySet();

    private Grupo() {
    }

    public Grupo(Long id) {
        this.id = id;
    }

    public Grupo(String nome, String objetivo, String igreja, StatusGrupo status) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.igreja = new Igreja(igreja);
        this.statusGrupo = status;
    }

    public static Grupo empty() {
        Grupo empty = new Grupo();
        empty.nome = "";
        empty.objetivo = "";
        empty.igreja = Igreja.empty();
        return empty;
    }

    public static Grupo from(GrupoDTO dto) {
        return new Grupo(dto.getNome(), dto.getObjetivo(), dto.getIgreja(), StatusGrupo.from(dto.getStatus()));
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

    public StatusGrupo getStatusGrupo() {
        return statusGrupo;
    }

    public Collection<Integrante> getIntegrantes() {
        return Collections.unmodifiableCollection(integrantes);
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
