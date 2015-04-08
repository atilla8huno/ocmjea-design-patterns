package com.oracle.ocmjea.gof.creational.abstract_factory;

/**
 * GoF's Pattern: Abstract Factory
 * 
 * O padrão Abstract Factory trabalha em volta de uma super-factory que cria outras factories.
 * Essa factory é também chamada de factory of factories (fábrica de fábricas).
 * Esse tipo de design pattern é do tipo Creational Pattern, bem como esse padrão provê um dos
 * melhores caminhos para criação de objetos.
 * 
 * No padrão Abstract Factory uma interface é responsável pela criação  de uma factory de objetos
 * relatados sem especificar explicitamente suas classes. Cada fábrica gerada pode dar os objetos 
 * de acordo com o padrão da fábrica.
 * 
 * Cenário aplicável:
 */
public class FactoryTest {

	public static void main(String[] args) {
		
		AbstractFactory moldeFactory = FactoryProdutor.getFactory("molde");
		
		Molde quadrado = moldeFactory.getMolde("quadrado");
		quadrado.desenhar();
		
		Molde circulo = moldeFactory.getMolde("circulo");
		circulo.desenhar();
		
		AbstractFactory corFactory = FactoryProdutor.getFactory("cor");
		
		Cor azul = corFactory.getCor("azul");
		azul.preencher();
		
		Cor vermelho = corFactory.getCor("vermelho");
		vermelho.preencher();
	}
}
