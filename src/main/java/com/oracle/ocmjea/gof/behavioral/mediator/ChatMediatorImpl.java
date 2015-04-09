package com.oracle.ocmjea.gof.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	@Override
	public void enviarMensagem(String msg, Usuario usuario) {
		for(Usuario u : usuarios){
            // Quem envia não deve receber a própria msg
            if(u != usuario){
                u.receber(msg);
            }
        }
	}

	@Override
	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
}
