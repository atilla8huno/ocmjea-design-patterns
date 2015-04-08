package com.oracle.ocmjea.gof.structural.decorator;

public class MoldeAzulDecorator extends MoldeDecorator {

	public MoldeAzulDecorator(Molde moldeDecorado) {
		super(moldeDecorado);
	}
	
	@Override
	public void desenhar() {
		super.desenhar();
		setCorAzul();
	}

	private void setCorAzul() {
		System.out.println("Pintando o molde de azul...");
	}
}
