package com.oracle.ocmjea.gof.behavioral.mediator;

public interface ChatMediator {

	void enviarMensagem(String msg, Usuario usuario);
	void addUsuario(Usuario usuario);
}
