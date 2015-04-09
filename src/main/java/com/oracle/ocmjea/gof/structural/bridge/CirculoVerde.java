package com.oracle.ocmjea.gof.structural.bridge;

public class CirculoVerde implements DesenhoAPI {

	@Override
	public void desenharCirculo(int radius, int x, int y) {
		System.out.println("Desenhando círculo verde [radius: " + radius +"]");
	}
}
