package com.oracle.ocmjea.gof.structural.decorator;

public abstract class MoldeDecorator implements Molde {

	protected Molde moldeDecorado;
	
	public MoldeDecorator(Molde moldeDecorado) {
		this.moldeDecorado = moldeDecorado;
	}

	public void desenhar() {
		moldeDecorado.desenhar();
	}
}
