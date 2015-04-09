package com.oracle.ocmjea.gof.structural.bridge;

/**
 * GoF's Pattern: Bridge
 * 
 * O padrão Bridge é usado quando precisamos desacoplar uma abstração de suas implementações, então
 * elas serão independentes. Este tipo de design pattern é do tipo Structural Pattern, bem como esse
 * pattern desacopla classes abstratas de classes concretas provendo uma espécie de ponte entre as duas.
 * 
 * Esse padrão envolve uma interface que atua como uma ponte (bridge) que garante a funcionadade das classes
 * concretas independente das classes implementadoras. Ambos os tipos de classes podem ser alterados sem
 * afetar uma a outra.
 * 
 * Cenário aplicável:
 */
public class DesenhoTest {

	public static void main(String[] args) {
		
		Molde circuloAzul = new Circulo(100, 100, 10, new CirculoAzul());
		Molde circuloVerde = new Circulo(80, 80, 8, new CirculoVerde());

		circuloAzul.desenhar();
		circuloVerde.desenhar();
	}
}
