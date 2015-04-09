package com.oracle.ocmjea.gof.behavioral.observer;

public class AcionistaC extends Acionista {

	public AcionistaC(Petrobras petrobras) {
		this.petrobras = petrobras;
		this.petrobras.addAcionista(this);
	}

	@Override
	public void analisarValores() {
		if (petrobras.getValorAcao() < 8.0) {
			System.out.println("[Acionista C] Vendendo tudo pq o buraco ficará mais fundo...");
		} else {
			System.out.println("[Acionista C] Mantendo ações por enquanto...");
		}
	}
}
