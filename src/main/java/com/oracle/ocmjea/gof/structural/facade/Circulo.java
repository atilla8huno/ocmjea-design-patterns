package com.oracle.ocmjea.gof.structural.facade;

public class Circulo implements Molde {

	@Override
	public void desenhar() {
		System.out.println("Circulo::desenhar");
	}
}
