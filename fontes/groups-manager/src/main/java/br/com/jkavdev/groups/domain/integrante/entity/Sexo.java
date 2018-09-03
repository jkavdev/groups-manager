package br.com.jkavdev.groups.domain.integrante.entity;

public enum Sexo {
	
	FEMININO("Feminino"),
	MASCULINO("Masculino");
	
	private String descricao;

	private Sexo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
