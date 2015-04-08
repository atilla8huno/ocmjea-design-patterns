package com.oracle.ocmjea.gof.creational.abstract_factory;

public class FactoryProdutor {

	public static AbstractFactory getFactory(String factory) {
		switch (factory) {
		case "cor":
			return new CorFactory();
		case "molde":
			return new MoldeFactory();
		default:
			return null;
		}
	}
}
