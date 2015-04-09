package com.oracle.ocmjea.gof.behavioral.interpreter;

public class ExpressaoAnd implements Expressao {

	private Expressao expressao1;
	private Expressao expressao2;

	public ExpressaoAnd(Expressao expressao1, Expressao expressao2) {
		this.expressao1 = expressao1;
		this.expressao2 = expressao2;
	}

	@Override
	public boolean interpretar(String expressao) {
		return expressao1.interpretar(expressao) && expressao2.interpretar(expressao);
	}
}
