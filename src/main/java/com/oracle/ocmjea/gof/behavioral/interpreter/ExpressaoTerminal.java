package com.oracle.ocmjea.gof.behavioral.interpreter;

public class ExpressaoTerminal implements Expressao {

	private String data;

	public ExpressaoTerminal(String data) {
		this.data = data;
	}

	@Override
	public boolean interpretar(String expressao) {
		return expressao.contains(data);
	}
}
