package com.oracle.ocmjea.gof.behavioral.template_method;

public class ShadowOfMordor extends Jogo {

	@Override
	public void iniciar() {
		System.out.println("[Shadow of Mordor] Carregando arquivos de som e imagens");
	}

	@Override
	public void introducao() {
		System.out.println("[Shadow of Mordor] Mordor, o pele rosa do mal!");
	}

	@Override
	public void finalizar() {
		System.out.println("[Shadow of Mordor] Limpando memória do console");
	}
}
