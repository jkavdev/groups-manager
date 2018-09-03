package br.com.jkavdev.groups.domain.evento.dto;

import br.com.jkavdev.groups.domain.evento.entity.Evento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDTO {

    private Long id;
    private LocalDateTime data;
    private String descricao;
    private String objetivo;
    private BigDecimal valor;
    private int lotacaoMaxima;

    public EventoDTO() {}

    public EventoDTO(Long id, LocalDateTime data, String descricao, String objetivo, BigDecimal valor) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.objetivo = objetivo;
        this.valor = valor;
    }
    public EventoDTO(LocalDateTime data, String descricao, String objetivo, BigDecimal valor) {
        this.data = data;
        this.descricao = descricao;
        this.objetivo = objetivo;
        this.valor = valor;
    }

    public static EventoDTO from(Evento evento) {
        return new EventoDTO(evento.getData(), evento.getDescricao(), evento.getObjetivo(), evento.getValor());
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
}
