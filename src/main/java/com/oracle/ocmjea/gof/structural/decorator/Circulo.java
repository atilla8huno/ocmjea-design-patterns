package com.oracle.ocmjea.gof.structural.decorator;

public class Circulo implements Molde {

	@Override
	public void desenhar() {
		System.out.println("Desenho em forma de círculo...");
	}
}
