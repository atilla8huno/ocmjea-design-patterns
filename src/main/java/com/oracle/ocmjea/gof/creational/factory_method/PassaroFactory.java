package com.oracle.ocmjea.gof.creational.factory_method;

public class PassaroFactory {

	public static Passaro getPassaro(String especie) {
		switch (especie) {
		case "Gaviao":
			return new Gaviao();
		case "Papagaio":
			return new Papagaio();
		case "Aguia":
			return new Aguia();
		default:
			return null;
		}
	}
}
