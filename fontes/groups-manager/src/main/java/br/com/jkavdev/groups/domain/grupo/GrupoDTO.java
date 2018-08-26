package br.com.jkavdev.groups.domain.grupo;

public class GrupoDTO {
	
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "GrupoDTO [nome=" + nome + "]";
	}
	
}
