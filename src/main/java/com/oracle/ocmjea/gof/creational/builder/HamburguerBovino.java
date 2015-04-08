package com.oracle.ocmjea.gof.creational.builder;

public class HamburguerBovino extends Hamburguer {

	@Override
	public String nome() {
		return "Hamburguer de Vaca";
	}

	@Override
	public double preco() {
		return 6.0;
	}
}
