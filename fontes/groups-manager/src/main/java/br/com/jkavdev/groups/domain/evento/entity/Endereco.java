package br.com.jkavdev.groups.domain.evento.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.core.style.ToStringCreator;

@Entity
public class Endereco {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String logradouro;

	@NotBlank
	private String unidade;
	
	@NotBlank
	private String localidade;
	
	@NotBlank
	private String bairro;

	@NotNull
	@Enumerated(EnumType.STRING)
	private UF uf;

	@NotBlank
	private String cep;

	private String complemento;
	
	private Endereco() {}
	
	public Endereco(String logradouro, String numero, String localidade,String unidade, UF uf, String cep, String bairro) {
		this.logradouro = logradouro;
		this.localidade = localidade;
		this.unidade = unidade;
		this.uf = uf;
		this.cep = cep;
		this.bairro = bairro;
	}
	
	public static Endereco empty() {
		Endereco empty = new Endereco();
		empty.logradouro = "";
		empty.localidade = "";
		empty.unidade = "";
		empty.uf = UF.NONE;
		empty.cep = "";
		empty.complemento = "";
		empty.bairro = "";
		return empty;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public void setUf(UF uf) {
		this.uf = uf;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return new ToStringCreator(this)
				.append("id", id)
				.append("logradouro", logradouro)
				.append("unidade", unidade)
				.append("bairro", bairro)
				.append("localidade", localidade)
				.append("uf", uf)
				.append("cep", cep)
				.append("complemento", complemento).toString();
	}
	
}
