package com.oracle.ocmjea.gof.behavioral.mediator;

public abstract class Usuario {

	protected String nome;
	protected ChatMediator mediator;

	public Usuario(String nome, ChatMediator mediator) {
		this.nome = nome;
		this.mediator = mediator;
	}

	public abstract void enviar(String msg);
	public abstract void receber(String msg);
}
