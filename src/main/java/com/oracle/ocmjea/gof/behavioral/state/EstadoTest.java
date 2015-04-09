package com.oracle.ocmjea.gof.behavioral.state;

/**
 * GoF's Pattern: State
 * 
 * No padrão State o comportamento de uma classe muda de acordo com seu estado. 
 * Nós criados objetos que representam vários estados e um objeto de contexo no qual seu 
 * comportamento varia a medida que seu objeto de estado muda.
 *  
 * Esse tipo de design pattern é do tipo Behavioral Pattern.
 * 
 * Cenário aplicável:
 */
public class EstadoTest {

	public static void main(String[] args) {
		
		Contexto contexto = new Contexto();

		StartState start = new StartState();
		start.fazUmaAcao(contexto);

		System.out.println(contexto.getState().toString() + "\n");

		StopState stop = new StopState();
		stop.fazUmaAcao(contexto);

		System.out.println(contexto.getState().toString());
	}
}
