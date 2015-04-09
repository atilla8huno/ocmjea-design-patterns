package com.oracle.ocmjea.gof.behavioral.state;

public class Contexto {

	private State state;

	public Contexto() {
		state = null;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}
}
