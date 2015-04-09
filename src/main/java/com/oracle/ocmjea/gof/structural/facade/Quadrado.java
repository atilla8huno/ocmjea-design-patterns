package com.oracle.ocmjea.gof.structural.facade;

public class Quadrado implements Molde {

	@Override
	public void desenhar() {
		System.out.println("Quadrado::desenhar");
	}
}
