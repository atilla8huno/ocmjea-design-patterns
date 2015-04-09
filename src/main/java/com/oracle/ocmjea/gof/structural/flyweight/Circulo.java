package com.oracle.ocmjea.gof.structural.flyweight;

public class Circulo implements Molde {

	private String cor;
	private int x;
	private int y;
	private int radius;

	public Circulo(String color) {
		this.cor = color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void desenhar() {
		System.out.println("Círculo: desenhar() [Cor : " + cor + ", x : " + x + ", y :" + y + ", radius :" + radius + "\n");
	}
}
