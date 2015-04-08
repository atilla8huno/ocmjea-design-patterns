package com.oracle.ocmjea.gof.creational.singleton;

public class ImpressoraUnica {

	private static ImpressoraUnica instancia;
	
	static {
		instancia = new ImpressoraUnica();
	}
	
	private ImpressoraUnica() {}
	
	public static ImpressoraUnica getInstancia() {
		return instancia;
	}
	
	public void imprimir(String dadosDeImpressao) {
		System.out.println(dadosDeImpressao);
	}
}
