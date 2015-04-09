package com.oracle.ocmjea.gof.structural.bridge;

public class Circulo extends Molde {

	private int x, y, radius;
	
	public Circulo(int x, int y, int radius, DesenhoAPI api) {
		super(api);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void desenhar() {
		api.desenharCirculo(radius, x, y);
	}
	
	public void fazOutraCoisaSemAfetarNinguem() {}
}
