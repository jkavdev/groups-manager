package br.com.jkavdev.groups.domain.noticia.entity;

import br.com.jkavdev.groups.domain.grupo.entity.Grupo;
import br.com.jkavdev.groups.domain.noticia.dto.NoticiaDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotNull
    @ElementCollection
    @JoinTable(
            name = "topico_noticia",
            joinColumns = @JoinColumn(name = "noticia_id"), foreignKey = @ForeignKey(name = "fk_topico_noticia_noticia_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "topico", nullable = false)
    private Set<Topico> topicos = new HashSet<>();

    @NotBlank
    @Lob
    private String corpo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo_id", foreignKey = @ForeignKey(name = "fk_noticia_grupo_id"))
    private Grupo grupo;

    @ElementCollection
    @JoinTable(
            name = "noticia_hits",
            joinColumns = @JoinColumn(name = "noticia_id"), foreignKey = @ForeignKey(name = "fk_noticia_hits_noticia_id"))
    @Column(name = "hit", nullable = false)
    private List<Boolean> informacaoUtil = new ArrayList<>();

    @Column(name = "aberta_ao_publico")
    private boolean publica;

    private String foto;

    public Noticia() {
    }

    public Noticia(Long id, String titulo, Set<Topico> topicos, String corpo, Grupo grupo, boolean publica) {
        this.id = id;
        this.titulo = titulo;
        this.topicos = topicos;
        this.corpo = corpo;
        this.grupo = grupo;
        this.publica = publica;
    }

    public static Noticia from(NoticiaDTO dto) {
        Noticia noticia = new Noticia(dto.getId(), dto.getTitulo(), dto.getTopicos(), dto.getCorpo(),
                Grupo.from(dto.getGrupo().getId()), dto.getPublica());
        return noticia;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public Set<Topico> getTopicos() {
        return Collections.unmodifiableSet(topicos);
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void marcar(boolean util) {
        this.informacaoUtil.add(util);
    }

    public void alterarDados(Noticia noticia) {
        this.titulo = noticia.titulo;
        this.topicos = noticia.topicos;
        this.corpo = noticia.corpo;
        this.publica = noticia.publica;
        this.foto = noticia.foto;
        this.grupo = noticia.grupo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("titulo", titulo)
                .toString();
    }

}
