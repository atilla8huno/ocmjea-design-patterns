package com.oracle.ocmjea.gof.behavioral.memento;

public class Pessoa {

	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PessoaOld salvarEstadoParaPessoaOld() {
		return new PessoaOld(nome);
	}

	public void getNomeAnteriorDaPessoa(PessoaOld memento) {
		nome = memento.getNome();
	}
}
