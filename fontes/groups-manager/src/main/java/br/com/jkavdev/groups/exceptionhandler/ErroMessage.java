package br.com.jkavdev.groups.exceptionhandler;

public class ErroMessage {
	
	public String mensagemUsuario;
	public String mensagemDesenvolvedor;

	public ErroMessage() {
	}
	public ErroMessage(String mensagemUsuario, String mensagemDesenvolvedor) {
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}
	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}
}
