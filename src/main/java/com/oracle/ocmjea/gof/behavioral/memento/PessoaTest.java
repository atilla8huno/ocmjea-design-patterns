package com.oracle.ocmjea.gof.behavioral.memento;

/**
 * GoF's Pattern: Memento
 * 
 * O padrão Memento é usado para restaurar o estado de um objeto para um estado anterior.
 * 
 * Esse tipo de design pattern é do tipo Behavioral Pattern.
 * 
 * Cenário aplicável:
 */
public class PessoaTest {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		EstadosPessoa estados = new EstadosPessoa();

		// não salva o estado
		pessoa.setNome("Primeiro nome...");

		// salva o estado
		pessoa.setNome("Segundo nome...");
		estados.add(pessoa.salvarEstadoParaPessoaOld());
		
		// salva o estado
		pessoa.setNome("Terceiro nome...");
		estados.add(pessoa.salvarEstadoParaPessoaOld());
		
		// estado atual
		pessoa.setNome("Quarto nome...");
		
		System.out.println("Estado atual: " + pessoa.getNome());

		pessoa.getNomeAnteriorDaPessoa(estados.get(0));
		System.out.println("Primeiro nome salvo: " + pessoa.getNome());
		
		pessoa.getNomeAnteriorDaPessoa(estados.get(1));
		System.out.println("Segundo nome salvo: " + pessoa.getNome());
	}
}
