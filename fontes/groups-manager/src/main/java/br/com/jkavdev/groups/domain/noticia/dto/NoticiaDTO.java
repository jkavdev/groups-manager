package br.com.jkavdev.groups.domain.noticia.dto;

import br.com.jkavdev.groups.domain.grupo.dto.GrupoDTO;
import br.com.jkavdev.groups.domain.noticia.entity.Topico;

public class NoticiaDTO {
	
	private GrupoDTO grupo;
	private String id;
	private String titulo;
	private String corpo;
	private Topico topicos;
	
	public NoticiaDTO(GrupoDTO grupo, String id, String titulo, String corpo, Topico topicos) {
		this.grupo = grupo;
		this.id = id;
		this.titulo = titulo;
		this.corpo = corpo;
		this.topicos = topicos;
	}
	
	public GrupoDTO getGrupo() {
		return grupo;
	}
	public void setGrupo(GrupoDTO grupo) {
		this.grupo = grupo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Topico getTopicos() {
		return topicos;
	}
	public void setTopicos(Topico topicos) {
		this.topicos = topicos;
	}
	@Override
	public String toString() {
		return "NoticiaDTO [grupo=" + grupo + ", id=" + id + ", titulo=" + titulo + ", corpo=" + corpo + ", topicos="
				+ topicos + "]";
	}
	
}
