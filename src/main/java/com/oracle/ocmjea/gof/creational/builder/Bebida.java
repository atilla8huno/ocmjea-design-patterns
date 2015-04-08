package com.oracle.ocmjea.gof.creational.builder;

public abstract class Bebida implements Item {

	@Override
	public Embalagem embalagem() {
		return new Garrafa();
	}
}
