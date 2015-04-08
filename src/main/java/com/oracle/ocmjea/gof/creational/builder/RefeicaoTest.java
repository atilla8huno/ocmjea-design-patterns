package com.oracle.ocmjea.gof.creational.builder;

/**
 * GoF's Pattern: Builder
 * 
 * O padrão Builder constrói um objeto complexo usando objetos simples e usando um passo-a-passo.
 * Esse tipo de design pattern é do tipo Creational Pattern, bem como esse padrão provê um dos
 * melhores caminhos para criação de objetos.
 *
 * Uma classe Builder cria o objeto final passo por passo. Esse builder é independente de outros objetos. 
 * 
 * Cenário aplicável:
 */
public class RefeicaoTest {

	public static void main(String[] args) {
		
		RefeicaoBuilder builder = new RefeicaoBuilder();
		
		Refeicao comboBovino = builder.prepararComboHamburguerBovino();
		System.out.println("Combo com Hamburguer Bovino e Coca-Cola");
		comboBovino.mostrarItens();
		System.out.println("Total: " + comboBovino.getValorTotal() + "\n");

		Refeicao comboFrango = builder.prepararComboHamburguerFrancoComPepsi();
		System.out.println("Combo com Hamburguer de Frango e Pepsi");
		comboFrango.mostrarItens();
		System.out.println("Total: " + comboFrango.getValorTotal() + "\n");
		
		Refeicao hambBonivo = builder.prepararHamburguerBovino();
		System.out.println("Apenas Hamburguer Bovino");
		hambBonivo.mostrarItens();
		System.out.println("Total: " + hambBonivo.getValorTotal() + "\n");
	}
}
