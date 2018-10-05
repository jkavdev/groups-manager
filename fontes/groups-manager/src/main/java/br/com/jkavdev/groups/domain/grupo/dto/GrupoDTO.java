package br.com.jkavdev.groups.domain.grupo.dto;

import br.com.jkavdev.groups.domain.evento.dto.EventoDTO;
import br.com.jkavdev.groups.domain.grupo.entity.Grupo;
import br.com.jkavdev.groups.domain.grupo.entity.Igrejas;
import br.com.jkavdev.groups.domain.grupo.entity.StatusGrupo;
import br.com.jkavdev.groups.domain.integrante.dto.IntegranteDTO;
import br.com.jkavdev.groups.domain.noticia.dto.NoticiaDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class GrupoDTO {

    private Long id;
    @NotBlank
    private String objetivo;
    @NotBlank
    private String nome;
    private String igreja;
    @NotNull
    private Long statusGrupoId;
    private StatusGrupo status;

    private List<EventoDTO> eventos = new ArrayList<>();
    private List<NoticiaDTO> noticias = new ArrayList<>();
    private List<IntegranteDTO> integrantes = new ArrayList<>();

    public GrupoDTO() {
    }

    private GrupoDTO(String nome, String objetivo, Long status) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.igreja = Igrejas.MENINO_DEUS.getIgreja();
        this.statusGrupoId = status;
        this.status = StatusGrupo.from(status);
    }

    public static GrupoDTO from(Grupo grupo) {
        GrupoDTO dto = new GrupoDTO(grupo.getNome(), grupo.getObjetivo(), grupo.getStatusGrupoId());
        dto.setId(grupo.getId());
        return dto;
    }

    public static GrupoDTO comEventos(Grupo grupo) {
        GrupoDTO dto = new GrupoDTO(grupo.getNome(), grupo.getObjetivo(), grupo.getStatusGrupoId());
        dto.setEventos(grupo.getEventos().stream().map(e -> EventoDTO.from(e)).collect(toList()));
        dto.setId(grupo.getId());
        return dto;
    }

    public static GrupoDTO comNoticias(Grupo grupo) {
        GrupoDTO dto = new GrupoDTO(grupo.getNome(), grupo.getObjetivo(), grupo.getStatusGrupoId());
        dto.setNoticias(grupo.getNoticias().stream().map(n -> NoticiaDTO.from(n)).collect(toList()));
        dto.setId(grupo.getId());
        return dto;
    }

    public static GrupoDTO comIntegrantes(Grupo grupo) {
        GrupoDTO dto = new GrupoDTO(grupo.getNome(), grupo.getObjetivo(), grupo.getStatusGrupoId());
        dto.setIntegrantes(grupo.getIntegrantes().stream().map(i -> IntegranteDTO.from(i)).collect(toList()));
        dto.setId(grupo.getId());
        return dto;
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

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getIgreja() {
        return igreja.toUpperCase();
    }

    public void setIgreja(String igreja) {
        this.igreja = igreja;
    }

    public Long getStatusGrupoId() {
        return statusGrupoId;
    }

    public void setStatusGrupoId(Long statusGrupoId) {
        this.statusGrupoId = statusGrupoId;
    }

    public StatusGrupo getStatus() {
        return status;
    }

    public void setStatus(StatusGrupo status) {
        this.status = status;
    }

    public List<EventoDTO> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoDTO> eventos) {
        this.eventos = eventos;
    }

    public List<NoticiaDTO> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<NoticiaDTO> noticias) {
        this.noticias = noticias;
    }

    public List<IntegranteDTO> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<IntegranteDTO> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .append("objetivo", objetivo)
                .append("igreja", igreja)
                .append("statusGrupo", StatusGrupo.from(statusGrupoId))
                .toString();
    }
}
