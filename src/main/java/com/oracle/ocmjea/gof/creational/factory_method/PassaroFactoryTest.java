package com.oracle.ocmjea.gof.creational.factory_method;

/**
 * GoF's Pattern: Factory Method or just Factory
 * 
 * Este tipo de design pattern é do tipo Creational Pattern e provê um dos melhores caminhos
 * para criar um objeto.
 * 
 * No padrão Factory, nós criamos objetos sem expor a lógica de criação para o cliente e
 * referencia o objeto recém-criado usando uma interface comúm.
 * 
 * Cenário aplicável:
 */
public class PassaroFactoryTest {

	public static void main(String[] args) {
		// Obtendo uma Água
		Passaro aguia = PassaroFactory.getPassaro("Aguia");
		aguia.voar();
		
		// Obtendo um Gavião
		Passaro gaviao = PassaroFactory.getPassaro("Gaviao");
		gaviao.voar();
		
		// Obtendo um Papagaio
		Passaro papagaio = PassaroFactory.getPassaro("Papagaio");
		papagaio.voar();
	}
}
