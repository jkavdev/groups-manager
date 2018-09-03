package br.com.jkavdev.groups.domain.integrante.repository;

import org.hibernate.validator.constraints.br.CPF;

public class IntegranteFilter {
	
	private String nome;
	private String grupo;
	@CPF
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "IntegranteFilter [nome=" + nome + ", grupo=" + grupo + ", cpf=" + cpf + "]";
	}
	
}
