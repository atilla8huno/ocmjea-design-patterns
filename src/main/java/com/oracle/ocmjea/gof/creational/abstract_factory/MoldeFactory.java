package com.oracle.ocmjea.gof.creational.abstract_factory;

public class MoldeFactory extends AbstractFactory {

	public Molde getMolde(String tipo) {
		switch (tipo) {
		case "circulo":
			return new Circulo();
		case "quadrado":
			return new Quadrado();
		default:
			return null;
		}
	}

	@Override
	public Cor getCor(String cor) {
		return null;
	}
}
