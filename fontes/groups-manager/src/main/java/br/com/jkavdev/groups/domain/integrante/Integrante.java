package br.com.jkavdev.groups.domain.integrante;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Integrante {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String celular;
	
	private String email;
	
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@CPF
	private String cpf;
	
	@Column(name = "membro_da_igreja")
	private Boolean membroDaIgreja;
	
	@Column(name = "membro_de_outra_igreja")
	private Boolean membroDeOutraIgreja;
	
	@Column(name = "nome_da_outra_igreja")
	private String outraIgreja;
	
	@Column(name = "cadastro_efetivado")
	private Boolean cadastroEfetivado;
	
	private Integrante() {}

	public Integrante(String nome, String celular, String email, Sexo sexo, LocalDate dataNascimento, String cpf) {
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}
	
	public static Integrante empty() {
		Integrante empty = new Integrante();
		empty.nome = "";
		empty.celular = "";
		empty.email = "";
		empty.senha = "";
		empty.celular = "";
		empty.sexo = Sexo.MASCULINO;
		empty.cpf = "";
		empty.dataNascimento = LocalDate.now();
		empty.membroDaIgreja = Boolean.FALSE;
		empty.membroDeOutraIgreja = Boolean.FALSE;
		empty.outraIgreja = "";
		empty.cadastroEfetivado = Boolean.FALSE;
		return empty;
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCelular() {
		return celular;
	}
	public String getEmail() {
		return email;
	}
	public String getCpf() {
		return cpf;
	}
	public Boolean getMembroDaIgreja() {
		return membroDaIgreja;
	}
	public String getOutraIgreja() {
		return outraIgreja;
	}
	public Boolean getCadastroEfetivado() {
		return cadastroEfetivado;
	}
	
	public void efetivarCadastro() {
		this.cadastroEfetivado = Boolean.TRUE;
	}

	@Override
	public String toString() {
		return "Integrante [nome=" + nome + ", email=" + email + "]";
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
		Integrante other = (Integrante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
