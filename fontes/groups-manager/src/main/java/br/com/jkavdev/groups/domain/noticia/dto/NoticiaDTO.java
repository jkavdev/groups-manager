package br.com.jkavdev.groups.domain.noticia.dto;

import br.com.jkavdev.groups.domain.grupo.dto.GrupoDTO;
import br.com.jkavdev.groups.domain.noticia.entity.Noticia;
import br.com.jkavdev.groups.domain.noticia.entity.Topico;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class NoticiaDTO {

    private String id;
    @NotNull
    private GrupoDTO grupo;
    @NotBlank
    private String titulo;
    @NotBlank
    private String corpo;
    @NotNull
    private Set<Topico> topicos;
    private Boolean publica;

    public NoticiaDTO() {
    }

    public NoticiaDTO(GrupoDTO grupo, String id, String titulo, String corpo, Set<Topico> topicos) {
        this.grupo = grupo;
        this.id = id;
        this.titulo = titulo;
        this.corpo = corpo;
        this.topicos = topicos;
    }

    public static NoticiaDTO from(Noticia noticia) {
        NoticiaDTO dto = new NoticiaDTO(GrupoDTO.from(noticia.getGrupo()), noticia.getId().toString(),
                noticia.getTitulo(), noticia.getCorpo(), new HashSet<>(noticia.getTopicos()));
        return dto;
    }

    public GrupoDTO getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoDTO grupo) {
        this.grupo = grupo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Set<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(Set<Topico> topicos) {
        this.topicos = topicos;
    }

    public Boolean getPublica() {
        return publica;
    }

    public void setPublica(Boolean publica) {
        this.publica = publica;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append(grupo)
                .append("id", id)
                .append("titulo", titulo)
                .append("corpo", corpo)
                .append("topicos", topicos)
                .toString();
    }
}
