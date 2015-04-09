package com.oracle.ocmjea.gof.structural.flyweight;

public class MoldeTest {

	private static final String cores[] = { "Red", "Green", "Blue", "White", "Black" };

	public static void main(String[] args) {
		
		// 20 iterações, mas apenas 5 (cores.lenght) objetos serão criados...
		for (int i = 0; i < 20; ++i) {
			
			Circulo circle = (Circulo) MoldeFactory.getCirculo(getCorRandom());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			
			circle.desenhar();
		}
	}

	private static String getCorRandom() {
		return cores[(int) (Math.random() * cores.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}
}
