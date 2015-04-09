package com.oracle.ocmjea.gof.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Petrobras {

	private List<Acionista> acionistas = new ArrayList<Acionista>();
	private double valorAcao;

	public double getValorAcao() {
		return valorAcao;
	}

	public void setValorAcao(double valorAcao) {
		this.valorAcao = valorAcao;
		notificarAcionistas();
	}

	public void addAcionista(Acionista acionista) {
		acionistas.add(acionista);
	}

	public void notificarAcionistas() {
		for (Acionista acionista : acionistas) {
			acionista.analisarValores();
		}
	}
}
