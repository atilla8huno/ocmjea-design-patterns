package com.oracle.ocmjea.gof.behavioral.mediator;

public class UsuarioImpl extends Usuario {

	public UsuarioImpl(String nome, ChatMediator mediator) {
		super(nome, mediator);
		mediator.addUsuario(this);
	}

	@Override
	public void enviar(String msg) {
		System.out.println(nome + " enviando mensagem: " + msg);
		mediator.enviarMensagem(msg, this);
	}

	@Override
	public void receber(String msg) {
		System.out.println(nome + " recebendo mensagem: " + msg);
	}
}
