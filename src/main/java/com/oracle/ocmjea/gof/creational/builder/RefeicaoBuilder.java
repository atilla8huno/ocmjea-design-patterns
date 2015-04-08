package com.oracle.ocmjea.gof.creational.builder;

public class RefeicaoBuilder {
	
	public Refeicao prepararComboHamburguerBovino() {
		Refeicao refeicao = new Refeicao();
		refeicao.addItem(new HamburguerBovino());
		refeicao.addItem(new CocaCola());
		return refeicao;
	}
	
	public Refeicao prepararHamburguerBovino() {
		Refeicao refeicao = new Refeicao();
		refeicao.addItem(new HamburguerBovino());
		return refeicao;
	}
	
	public Refeicao prepararComboHamburguerFranco() {
		Refeicao refeicao = new Refeicao();
		refeicao.addItem(new HamburguerBovino());
		refeicao.addItem(new CocaCola());
		return refeicao;
	}
	
	public Refeicao prepararComboHamburguerFrancoComPepsi() {
		Refeicao refeicao = new Refeicao();
		refeicao.addItem(new HamburguerFrango());
		refeicao.addItem(new Pepsi());
		return refeicao;
	}
}
