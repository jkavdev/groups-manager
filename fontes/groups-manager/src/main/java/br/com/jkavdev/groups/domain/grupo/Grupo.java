package br.com.jkavdev.groups.domain.grupo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.core.style.ToStringCreator;

import br.com.jkavdev.groups.domain.evento.Evento;
import br.com.jkavdev.groups.domain.integrante.Integrante;
import br.com.jkavdev.groups.domain.noticia.Noticia;

@Entity
public class Grupo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String objetivo;
	
	@NotBlank
	private String igreja;
	
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
	
	private Grupo() {}
	public Grupo(Long id) {
		this.id = id;
	}
	public Grupo(Long id, String nome, String objetivo, String igreja) {
		this.id = id;
		this.nome = nome;
		this.objetivo = objetivo;
		this.igreja = igreja;
	}

	public static Grupo empty() {
		Grupo empty = new Grupo();
		empty.nome = "";
		empty.objetivo = "";
		empty.igreja = "";
		return empty;
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
	public String getIgreja() {
		return igreja;
	}
	public void setIgreja(String igreja) {
		this.igreja = igreja;
	}
	public String getObjetivo() {
		return objetivo;
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
		return new ToStringCreator(this)
				.append("id", id)
				.append("nome", nome)
				.append("igreja", igreja).toString();
	}
}
