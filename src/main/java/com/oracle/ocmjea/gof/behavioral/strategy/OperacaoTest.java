package com.oracle.ocmjea.gof.behavioral.strategy;

/**
 * GoF's Pattern: Strategy
 * 
 * No padrão Strategy, o comportamento de uma classe ou seu algoritmo pode ser alterado
 * em tempo de execução. Esse tipo de design pattern é do tipo Behavioral Pattern.
 * 
 * No padrão Strategy, nós criamos objetos que representam várias estratégias e um objeto
 * Contexto no qual o comportamento varia de acordo com a estratégia.
 * O objeto de estratégia muda a execução do algoritmo do objeto Contexto.
 * 
 * Cenário aplicável:
 */
public class OperacaoTest {

	public static void main(String[] args) {
		// Adicionando a estratégia de multiplicação no contexto
		Contexto contexto = new Contexto(new OperacaoMultiplicacao());
		System.out.println("10 * 10 = " + 
				contexto.executarEstrategia(10, 10));
		
		// Adicionando a estratégia de soma no contexto
		contexto = new Contexto(new OperacaoSoma());
		System.out.println("10 + 5 = " + 
				contexto.executarEstrategia(10, 5));
		
		// Adicionando a estratégia de subtracao no contexto
		contexto = new Contexto(new OperacaoSubtracao());
		System.out.println("18 - 3 = " + 
				contexto.executarEstrategia(18, 3));
	}
}
