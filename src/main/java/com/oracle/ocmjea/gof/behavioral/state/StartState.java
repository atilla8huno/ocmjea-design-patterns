package com.oracle.ocmjea.gof.behavioral.state;

public class StartState implements State {

	@Override
	public void fazUmaAcao(Contexto contexto) {
		System.out.println("Ficando no estado STARTED");
		contexto.setState(this);
	}

	@Override
	public String toString() {
		return "Estado: Start";
	}
}
