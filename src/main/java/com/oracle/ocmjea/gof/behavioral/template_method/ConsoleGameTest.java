package com.oracle.ocmjea.gof.behavioral.template_method;

/**
 * GoF's Pattern: Template Method
 * 
 * No padrão Template, uma abstract class expoem caminhos definidos/template(s) para executar seus métodos.
 * Suas subclasses podem sobrescrever a implementação dos métodos de acordo com a necessidade, mas a
 * invocação é definida no mesmo caminho definido na abstract class.
 * 
 * Esse tipo de design pattern é do tipo Behavioral Pattern.
 * 
 * Cenário aplicável:
 */
public class ConsoleGameTest {

	public static void main(String[] args) {
		
		System.out.println("Jogarei Fifa 15...");
		Jogo fifa15 = new Fifa15();
		fifa15.jogar();
		
		System.out.println("\nJogarei Shadow of Mordor...");
		Jogo mordor = new ShadowOfMordor();
		mordor.jogar();
	}
}
