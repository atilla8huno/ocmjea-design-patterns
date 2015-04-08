package com.oracle.ocmjea.gof.creational.builder;

public class HamburguerFrango extends Hamburguer {

	@Override
	public String nome() {
		return "Hamburguer de Frango";
	}

	@Override
	public double preco() {
		return 5.0;
	}
}
