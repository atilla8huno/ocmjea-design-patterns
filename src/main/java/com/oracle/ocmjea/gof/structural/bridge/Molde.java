package com.oracle.ocmjea.gof.structural.bridge;

public abstract class Molde {

	protected DesenhoAPI api;

	protected Molde(DesenhoAPI api) {
		this.api = api;
	}

	public abstract void desenhar();
}
