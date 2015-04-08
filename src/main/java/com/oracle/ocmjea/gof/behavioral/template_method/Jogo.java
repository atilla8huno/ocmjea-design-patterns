package com.oracle.ocmjea.gof.behavioral.template_method;

public abstract class Jogo {

	public abstract void iniciar();
	public abstract void introducao();
	public abstract void finalizar();
	
	public void jogar() {
		try {
			iniciar();
			introducao();
		} finally {
			finalizar();
		}
	}
}
