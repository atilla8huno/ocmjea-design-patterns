package com.oracle.ocmjea.gof.creational.abstract_factory;

public abstract class AbstractFactory {

	public abstract Molde getMolde(String tipo);
	public abstract Cor getCor(String cor);
}
