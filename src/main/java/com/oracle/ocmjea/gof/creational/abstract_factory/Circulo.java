package com.oracle.ocmjea.gof.creational.abstract_factory;

public class Circulo implements Molde {

	@Override
	public void desenhar() {
		System.out.println("Desenhando um círculo...");
	}
}
