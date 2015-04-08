package com.oracle.ocmjea.gof.creational.builder;

public abstract class Hamburguer implements Item {

	@Override
	public Embalagem embalagem() {
		return new Papel();
	}
}
