package com.oracle.ocmjea.gof.structural.facade;

public class MoldeFacade {

	private Molde circulo;
	private Molde quadrado;
	private Molde retangulo;
	
	public MoldeFacade() {
		circulo = new Circulo();
		quadrado = new Quadrado();
		retangulo = new Retangulo();
	}
	
	public void desenharCirculo() {
		circulo.desenhar();
	}
	
	public void desenharQuadrado() {
		quadrado.desenhar();
	}
	
	public void desenharRetangulo() {
		retangulo.desenhar();
	}
}
