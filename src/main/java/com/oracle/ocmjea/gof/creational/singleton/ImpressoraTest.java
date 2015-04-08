package com.oracle.ocmjea.gof.creational.singleton;

/**
 * GoF's Pattern: Singleton
 * 
 * O padrão Singleton é um dos design paterrns mais simples no Java. Este tipo de design pattern é 
 * do tipo Creational Pattern e provê um dos melhores caminhos para criar um objeto.
 * 
 * Esse padrão envolve uma única classe que é responsável por criar objetos enquanto tem certeza que
 * apenas um único objeto é criado. Essa classe fornece uma maneira de acessar o seu único objeto que 
 * pode ser acessado diretamente sem a necessidade de instânciar o objeto da classe.
 * 
 * Cenário aplicável:
 */
public class ImpressoraTest {

	public static void main(String[] args) {
		
//		erro de compilação:
//		ImpressoraUnica impressora = new ImpressoraUnica();
		
		ImpressoraUnica impressora = ImpressoraUnica.getInstancia();
		impressora.imprimir("Fatura do Cartão de Crédito - Abril/2015");
		System.out.println("Objeto: " + impressora);
		
		// a mesma instância
		impressora = ImpressoraUnica.getInstancia();
		impressora.imprimir("\nFatura do Cartão de Crédito - Maio/2015");
		System.out.println("Objeto: " + impressora);
	}
}
