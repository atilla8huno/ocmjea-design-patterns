package com.oracle.ocmjea.gof.behavioral.iterator;

/**
 * GoF's Pattern: Iterator
 * 
 * O padrão Iterator é um padrão muito usado no ambiente Java e .Net. Esse padrão é usado para obter um
 * caminho para acessar os elementos de uma Collection de maneira sequencial, sem qualquer necessidade
 * de conhecer a sua representação por baixo dos panos.
 * 
 * Esse tipo de design pattern é do tipo Behavioral Pattern.
 * 
 * Cenário aplicável:
 */
public class IteratorTest {

	public static void main(String[] args) {
		NomeDAO nomeDAO = new NomeDAO();

		for (Iterador iter = nomeDAO.getIterador(); iter.temProximo();) {
			String name = (String) iter.proximo();
			System.out.println("Nome : " + name);
		}
	}
}
