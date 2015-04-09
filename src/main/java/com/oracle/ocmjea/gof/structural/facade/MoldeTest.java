package com.oracle.ocmjea.gof.structural.facade;

/**
 * GoF's Pattern: Facade
 * 
 * O padrão Facade esconde a complexidade do sistema e provê uma interface para o cliente que usando a
 * interface o cliente pode acessar o sistema. Esse tipo de design pattern é do tipo Structural Pattern, 
 * bem como este padrão adiciona uma interface para um sistema existente para esconder a complexidade.
 * 
 * Esse padrão envolve uma única classe que provê métodos simplificados requeridos pelo cliente e delega
 * a chamada para métodos existentes nas classes do sistema.
 * 
 * Cenário aplicável:
 */
public class MoldeTest {

	public static void main(String[] args) {
		
		MoldeFacade molder = new MoldeFacade();
		
		molder.desenharCirculo();
		molder.desenharQuadrado();
		molder.desenharRetangulo();
	}
}
