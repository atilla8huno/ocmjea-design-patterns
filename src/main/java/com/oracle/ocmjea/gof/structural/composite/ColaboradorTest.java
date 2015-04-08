package com.oracle.ocmjea.gof.structural.composite;

/**
 * GoF's Pattern: Composite
 * 
 * O padrão Composite é usado onde nós precisamos tratar um grupo de objetos de forma similar a um objeto único.
 * Composite Pattern compoem objetos no termo de uma estrutura de árvore para representar uma parte, bem como
 * suas hierarquias. Esse tipo de design pattern é do tipo Structural Pattern, bem como esse padrão cria uma
 * estrutura de árvore do grupo de objetos.
 * 
 * Este padrão cria uma classe que contém um grupo de seus próprios objetos. Essa classe provê caminhos para
 * modificar esse grupo de objetos do mesmo tipo.
 * 
 * Cenário aplicável:
 */
public class ColaboradorTest {

	public static void main(String[] args) {
		Colaborador CEO = new Colaborador("Jonathas", "CEO", 35000.0);
		
		Colaborador gerenteRH = new Colaborador("Raquel", "Gerente de RH", 8000.0);
		Colaborador gerenteSuporte = new Colaborador("Gustavo", "Gerente de Operações", 8000.0);
		Colaborador gerenteDesenv = new Colaborador("Thiago", "Gerente de Desenv", 8000.0);
		
		Colaborador rhOper1 = new Colaborador("Simone", "RH", 1000.0);
		Colaborador suporteOper1 = new Colaborador("Isaias", "Suporte", 4000.0);
		Colaborador suporteOper2 = new Colaborador("Maykon", "Suporte", 1000.0);
		Colaborador desenvOper1 = new Colaborador("Átilla", "Desenv", 5000.0);
		Colaborador desenvOper2 = new Colaborador("Warley", "Desenv", 6000.0);
		Colaborador desenvOper3 = new Colaborador("Léo", "Desenv", 4000.0);
		
		CEO.add(gerenteRH);
		CEO.add(gerenteSuporte);
		CEO.add(gerenteDesenv);
		
		gerenteRH.add(rhOper1);
		
		gerenteSuporte.add(suporteOper1);
		gerenteSuporte.add(suporteOper2);
		
		gerenteDesenv.add(desenvOper1);
		gerenteDesenv.add(desenvOper2);
		gerenteDesenv.add(desenvOper3);
		
		System.out.println("Lista de Colaboradores da Empresa: \n");
		System.out.println(CEO);
		
		for (Colaborador gerente : CEO.getSubordinados()) {
			System.out.println(gerente);
			
			for (Colaborador sub : gerente.getSubordinados()) {
				System.out.println(sub);
			}
		}
	}
}
