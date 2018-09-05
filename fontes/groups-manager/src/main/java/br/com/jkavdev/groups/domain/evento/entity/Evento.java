package br.com.jkavdev.groups.domain.evento.entity;

import br.com.jkavdev.groups.domain.evento.dto.EventoDTO;
import br.com.jkavdev.groups.domain.grupo.entity.Grupo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime data;

    @NotBlank
    private String descricao;

    @NotBlank
    @Column(columnDefinition = "text")
    private String objetivo;

    private BigDecimal valor;

    @NotNull
    @Column(name = "lotacao_maxima")
    private Integer lotacaoMaxima;

    @NotNull
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", foreignKey = @ForeignKey(name = "fk_evento_endereco_id"))
    private Endereco endereco;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo_id", foreignKey = @ForeignKey(name = "fk_evento_grupo_id"))
    private Grupo grupo;

    private Evento() {
    }

    public Evento(LocalDateTime data, String descricao, String objetivo, BigDecimal valor, Integer lotacaoMaxima,
                  Endereco endereco, Grupo grupo) {
        this.data = data;
        this.descricao = descricao;
        this.objetivo = objetivo;
        this.valor = valor;
        this.lotacaoMaxima = lotacaoMaxima;
        this.endereco = endereco;
        this.grupo = grupo;
    }

    public static Evento from(EventoDTO dto) {
        Objects.requireNonNull(dto);
        Objects.requireNonNull(dto.getEndereco());
        Objects.requireNonNull(dto.getGrupoId());
        return new Evento(dto.getData(), dto.getDescricao(), dto.getObjetivo(), dto.getValor(), dto.getLotacaoMaxima(), Endereco.from(dto.getEndereco()), Grupo.from(dto.getGrupoId()));
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void setObjetivo(String motivo) {
        this.objetivo = motivo;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLotacaoMaxima(int lotacaoMaxima) {
        this.lotacaoMaxima = lotacaoMaxima;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("data", data)
                .append("descricao", descricao)
                .append("valor", valor)
                .append("lotacaoMaxima", lotacaoMaxima)
                .toString();
    }

}
