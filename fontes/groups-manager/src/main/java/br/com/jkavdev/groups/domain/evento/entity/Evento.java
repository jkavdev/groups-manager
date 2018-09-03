package br.com.jkavdev.groups.domain.evento.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.core.style.ToStringCreator;

import br.com.jkavdev.groups.domain.grupo.entity.Grupo;

@Entity
public class Evento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private int lotacaoMaxima;
	
	@NotNull
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "endereco_id", foreignKey = @ForeignKey(name = "fk_endereco_id"))
	private Endereco endereco;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "grupo_id", foreignKey = @ForeignKey(name = "fk_evento_grupo_id"))
	private Grupo grupo;
	
	public Evento() {}

	public Evento(LocalDateTime data, String descricao, String motivo, BigDecimal valor, int lotacaoMaxima,
			Endereco endereco, Grupo grupo) {
		this.data = data;
		this.descricao = descricao;
		this.objetivo = motivo;
		this.valor = valor;
		this.lotacaoMaxima = lotacaoMaxima;
		this.endereco = endereco;
		this.grupo = grupo;
	}
	
	public static Evento empty() {
		Evento empty = new Evento();
		empty.data = LocalDateTime.now();
		empty.descricao = "";
		empty.objetivo = "";
		empty.valor = BigDecimal.ZERO;
		empty.lotacaoMaxima = 0;
		empty.endereco = Endereco.empty();
		empty.grupo = Grupo.empty();
		return empty;
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
		return new ToStringCreator(this)
				.append("id", id)
				.append("data", data)
				.append("descricao", descricao)
				.append("valor", valor)
				.append("lotacaoMaxima", lotacaoMaxima).toString();
	}

}
