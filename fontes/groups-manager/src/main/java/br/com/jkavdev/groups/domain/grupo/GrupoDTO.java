package br.com.jkavdev.groups.domain.grupo;

import br.com.jkavdev.groups.domain.evento.dto.EventoDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class GrupoDTO {

    @NotBlank
    private String objetivo;
    @NotBlank
    private String nome;
    @NotBlank
    private String igreja;
    @NotNull
    private StatusGrupoDTO status;
    List<EventoDTO> eventos = new ArrayList<>();

    public GrupoDTO() {
    }

    private GrupoDTO(String nome, String objetivo, String igreja, StatusGrupoDTO status) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.igreja = igreja;
        this.status = status;
    }

    public static GrupoDTO from(Grupo grupo) {
        return new GrupoDTO(grupo.getNome(), grupo.getObjetivo(), grupo.getIgreja().getNome(), StatusGrupoDTO.from(grupo.getStatusGrupo()));
    }

    public static GrupoDTO comEventos(Grupo grupo) {
        GrupoDTO dto = new GrupoDTO(grupo.getNome(), grupo.getObjetivo(), "", null);
        dto.setEventos(grupo.getEventos().stream().map(e -> EventoDTO.from(e)).collect(toList()));
        return dto;
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

    public StatusGrupoDTO getStatus() {
        return status;
    }

    public void setStatus(StatusGrupoDTO status) {
        this.status = status;
    }

    public List<EventoDTO> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoDTO> eventos) {
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .append("objetivo", objetivo)
                .append("igreja", igreja)
                .append(status)
                .toString();
    }
}
