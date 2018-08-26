package br.com.jkavdev.groups.domain.noticia;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.core.style.ToStringCreator;

import br.com.jkavdev.groups.domain.grupo.Grupo;

@Entity
public class Noticia {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String titulo;

	@NotNull
	@ElementCollection
	@JoinTable(
			name = "topico_noticia",
			joinColumns=@JoinColumn(name = "noticia_id"), foreignKey = @ForeignKey(name = "fk_topico_noticia_noticia_id"))
	@Enumerated(EnumType.STRING)
	@Column(name = "topico", nullable = false)
	private Set<Topico> topicos = Collections.emptySet();

	@NotBlank
	@Column(columnDefinition = "text")
	private String corpo;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "grupo_id", foreignKey = @ForeignKey(name = "fk_noticia_grupo_id"))
	private Grupo grupo;

	@ElementCollection
	@JoinTable(
			name = "noticia_hits",
			joinColumns=@JoinColumn(name = "noticia_id"), foreignKey = @ForeignKey(name = "fk_noticia_hits_noticia_id"))
	@Column(name = "hit", nullable = false)
	private List<Boolean> informacaoUtil = Collections.emptyList();

	@Column(name = "aberta_ao_publico")
	private boolean publica;

	private String foto;

	public Noticia() {}

	public Noticia(String titulo, Set<Topico> topicos, String corpo, Grupo grupo) {
		this.titulo = titulo;
		this.topicos = topicos;
		this.corpo = corpo;
		this.grupo = grupo;
	}

	public static Noticia empty() {
		Noticia empty = new Noticia();
		empty.titulo = "";
		empty.corpo = "";
		empty.grupo = Grupo.empty();
		return empty;
	}

	public Long getId() {
		return id;
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
	public Collection<Topico> getTopicos() {
		return topicos;
	}
	public void setTopicos(Set<Topico> topicos) {
		this.topicos = topicos;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public String getFoto() {
		return foto;
	}
	public void setPublica(boolean publica) {
		this.publica = publica;
	}

	public void adiciona(Boolean util) {
		this.informacaoUtil.add(util);
	}

	@Override
	public String toString() {
		return new ToStringCreator(this)
				.append("id", id)
				.append("titulo", titulo)
				.append("grupo", grupo.getNome()).toString();
	}

}
