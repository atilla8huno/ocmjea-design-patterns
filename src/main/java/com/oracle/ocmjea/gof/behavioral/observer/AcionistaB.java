package com.oracle.ocmjea.gof.behavioral.observer;

public class AcionistaB extends Acionista {

	public AcionistaB(Petrobras petrobras) {
		this.petrobras = petrobras;
		this.petrobras.addAcionista(this);
	}

	@Override
	public void analisarValores() {
		if (petrobras.getValorAcao() < 8.0) {
			System.out.println("[Acionista B] Comprando mais ações enquanto está barato...");
		} else if (petrobras.getValorAcao() >= 8.0 && petrobras.getValorAcao() < 18.0) {
			System.out.println("[Acionista B] Mantendo ações...");
		} else {
			System.out.println("[Acionista B] Vendendo ações pq valorizaram...");
		}
	}
}
