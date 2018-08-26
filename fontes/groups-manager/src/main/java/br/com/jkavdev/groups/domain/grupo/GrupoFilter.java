package br.com.jkavdev.groups.domain.grupo;

public class GrupoFilter {
	
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "GrupoFilter [nome=" + nome + "]";
	}
	
}
