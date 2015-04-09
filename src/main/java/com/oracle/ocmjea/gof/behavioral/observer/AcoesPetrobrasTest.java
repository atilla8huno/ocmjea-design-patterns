package com.oracle.ocmjea.gof.behavioral.observer;

/**
 * GoF's Pattern: Observer
 * 
 * O padrão Observer é usado quando há um relacionamento one-to-many entre objetos de forma que se um
 * objeto é modificado, os objetos relacionados são notificados automaticamente.
 * 
 * Esse tipo de design pattern é do tipo Behavioral Pattern.
 * 
 * Cenário aplicável:
 */
public class AcoesPetrobrasTest {

	public static void main(String[] args) {
		
		Petrobras petrobras = new Petrobras();

		new AcionistaA(petrobras);
		new AcionistaB(petrobras);
		new AcionistaC(petrobras);
		
		System.out.println("Ação inicial da petrobrás: R$ 10,00");
		petrobras.setValorAcao(10.0);
		
		System.out.println("\nAções em queda: R$ 7,00");
		petrobras.setValorAcao(7.0);
		
		System.out.println("\nAções em alta: R$ 16,00");
		petrobras.setValorAcao(16.0);
		
		System.out.println("\nAções em alta novamente: R$ 20,00");
		petrobras.setValorAcao(20.0);
	}
}
