package br.com.jkavdev.groups.domain.evento.dto;

import br.com.jkavdev.groups.domain.evento.entity.Evento;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDTO {

    private Long id;
    @NonNull
    private LocalDateTime data;
    @NotBlank
    private String descricao;
    @NotBlank
    private String objetivo;
    @NonNull
    private BigDecimal valor;
    @NonNull
    private Integer lotacaoMaxima;

    @NonNull
    private Long grupoId;

    @NonNull
    private EnderecoDTO endereco;

    public EventoDTO() {
    }

    //usado por filtrar
    public EventoDTO(Long id, LocalDateTime data, String descricao, String objetivo, BigDecimal valor) {
        this(data, descricao, objetivo, valor);
        this.id = id;
    }

    public EventoDTO(Long id, LocalDateTime data, String descricao, String objetivo,
                     Integer lotacaoMaxima, BigDecimal valor, EnderecoDTO endereco) {
        this(data, descricao, objetivo, valor);
        this.lotacaoMaxima = lotacaoMaxima;
        this.endereco = endereco;
        this.id = id;
    }

    public EventoDTO(LocalDateTime data, String descricao, String objetivo, BigDecimal valor) {
        this.data = data;
        this.descricao = descricao;
        this.objetivo = objetivo;
        this.valor = valor;
    }

    public static EventoDTO from(Evento evento) {
        EventoDTO dto = new EventoDTO(evento.getId(), evento.getData(), evento.getDescricao(), evento.getObjetivo(),
                evento.getLotacaoMaxima(), evento.getValor(), EnderecoDTO.from(evento.getEndereco()));
        dto.setGrupoId(evento.getGrupo().getId());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    public void setLotacaoMaxima(Integer lotacaoMaxima) {
        this.lotacaoMaxima = lotacaoMaxima;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("data", data)
                .append("descricao", descricao)
                .append("objetivo", objetivo)
                .append("valor", valor)
                .append("lotacaoMaxima", lotacaoMaxima)
                .append("grupoId", grupoId)
                .append(endereco)
                .toString();
    }
}
