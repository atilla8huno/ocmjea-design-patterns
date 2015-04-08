package com.oracle.ocmjea.gof.creational.abstract_factory;

public class CorFactory extends AbstractFactory {

	public Cor getCor(String cor) {
		switch (cor) {
		case "azul":
			return new Azul();
		case "vermelho":
			return new Vermelho();
		default:
			return null;
		}
	}

	@Override
	public Molde getMolde(String tipo) {
		return null;
	}
}
