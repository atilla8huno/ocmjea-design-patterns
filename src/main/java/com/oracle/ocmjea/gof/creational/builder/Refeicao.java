package com.oracle.ocmjea.gof.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class Refeicao {

	private List<Item> itens = new ArrayList<Item>();

	public void addItem(Item item) {
		itens.add(item);
	}

	public double getValorTotal() {
		double cost = 0.0;

		for (Item item : itens) {
			cost += item.preco();
		}
		return cost;
	}

	public void mostrarItens() {
		for (Item item : itens) {
			System.out.print("Item : " + item.nome());
			System.out.print(", Embalagem : " + item.embalagem().pacote());
			System.out.println(", Valor : " + item.preco());
		}
	}
}
