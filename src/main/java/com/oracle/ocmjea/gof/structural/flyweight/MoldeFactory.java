package com.oracle.ocmjea.gof.structural.flyweight;

import java.util.HashMap;

@SuppressWarnings("all")
public class MoldeFactory {

	// pool de objetos
	private static final HashMap<String, Molde> circleMap = new HashMap();

	public static Molde getCirculo(String color) {
		Circulo circulo = (Circulo) circleMap.get(color);

		// verifica se conseguiu aproveitar algum objeto
		if (circulo == null) {
			circulo = new Circulo(color);
			circleMap.put(color, circulo);
			
			System.out.println("Criando um novo círculo da cor: " + color);
		}
		
		return circulo;
	}
}
