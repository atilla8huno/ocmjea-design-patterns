package com.oracle.ocmjea.gof.behavioral.mediator;

/**
 * GoF's Pattern: Mediator
 * 
 * O padrão Mediator é usado para reduzir a complexidade na comunicação entre multiplos objetos ou classes.
 * Esse padrão provê uma classe mediadora que normalmente recebe todas as comunicações entre diferentes
 * classes e suporta uma manutenção de código fácil por reduzir o acoplamento. 
 * 
 * Esse tipo de design pattern é do tipo Behavioral Pattern.
 * 
 * Cenário aplicável:
 */
public class ChatTest {

	public static void main(String[] args) {
		
		ChatMediator mediador = new ChatMediatorImpl();
		
		Usuario user1 = new UsuarioImpl("Átilla", mediador);
		Usuario user2 = new UsuarioImpl("Jullierme", mediador);
		Usuario user3 = new UsuarioImpl("Ben-Hur", mediador);
		Usuario user4 = new UsuarioImpl("Maria Rosa", mediador);
		
		user1.enviar("E aí, pessoal...");
		
		System.out.println();
		user4.enviar("Bom dia, família linda!");
		
		System.out.println();
		user2.enviar("Tem almoço? Estou indo almoçar aí...");
		
		System.out.println();
		user3.enviar("Vcs virão para meu aniversário, né?!");
	}
}
