package com.oracle.ocmjea.gof.behavioral.state;

public class StopState implements State {

	@Override
	public void fazUmaAcao(Contexto contexto) {
		System.out.println("Ficando no estado STOPED");
		contexto.setState(this);
	}

	@Override
	public String toString() {
		return "Estado: Stop";
	}
}
