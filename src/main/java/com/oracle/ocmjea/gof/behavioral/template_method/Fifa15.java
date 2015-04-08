package com.oracle.ocmjea.gof.behavioral.template_method;

public class Fifa15 extends Jogo {

	@Override
	public void iniciar() {
		System.out.println("[Fifa 15] Carregando arquivos de som e imagens");
	}

	@Override
	public void introducao() {
		System.out.println("[Fifa 15] EA Sports: It's in the game!");
	}

	@Override
	public void finalizar() {
		System.out.println("[Fifa 15] Limpando memória do console");
	}
}
