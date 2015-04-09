package com.oracle.ocmjea.gof.behavioral.observer;

public class AcionistaA extends Acionista {

	public AcionistaA(Petrobras petrobras) {
		this.petrobras = petrobras;
		this.petrobras.addAcionista(this);
	}

	@Override
	public void analisarValores() {
		if (petrobras.getValorAcao() < 8.0) {
			System.out.println("[Acionista A] Comprando mais ações enquanto está barato...");
		} else if (petrobras.getValorAcao() < 12.0) {
			System.out.println("[Acionista A] Mantendo ações...");
		} else {
			System.out.println("[Acionista A] Vendendo ações...");
		}
	}
}
