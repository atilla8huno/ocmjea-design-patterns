package com.oracle.ocmjea.gof.behavioral.interpreter;

/**
 * GoF's Pattern: Interpreter
 * 
 * O padrão Interpreter provê formas para avaliar uma expressão ou gramática.
 * Esse padrão dita a implementação de uma interface de expressão que diz para interpretar um contexto particular.
 * Esse padrão é usado em SQL parsing, processamento de símbolos, google translate, etc.
 * 
 * Esse tipo de design pattern é do tipo Behavioral Pattern.
 * 
 * Cenário aplicável:
 */
public class ExpressaoTest {

	public static void main(String[] args) {

		Expressao isMale = getMaleExpressao();
		Expressao isMarriedWoman = getMarriedWomanExpressao();

		System.out.println("John é homem? " + isMale.interpretar("John"));
		System.out.println("Julie é uma mulher casada? " + isMarriedWoman.interpretar("Married Julie"));
	}

	// Rule: Robert e John são homens
	public static Expressao getMaleExpressao() {
		Expressao robert = new ExpressaoTerminal("Robert");
		Expressao john = new ExpressaoTerminal("John");
		return new ExpressaoOr(robert, john);
	}

	// Rule: Julie é uma mulher casada
	public static Expressao getMarriedWomanExpressao() {
		Expressao julie = new ExpressaoTerminal("Julie");
		Expressao married = new ExpressaoTerminal("Married");
		return new ExpressaoAnd(julie, married);
	}
}
