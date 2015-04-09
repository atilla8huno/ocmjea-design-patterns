package com.oracle.ocmjea.gof.structural.bridge;

public class CirculoAzul implements DesenhoAPI {

	@Override
	public void desenharCirculo(int radius, int x, int y) {
		System.out.println("Desenhando círculo azul [radius: " + radius +"]");
	}
	
	public void fazAlgoSemAfetarNinguem() {}
}
