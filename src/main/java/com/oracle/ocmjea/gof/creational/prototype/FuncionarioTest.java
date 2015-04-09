package com.oracle.ocmjea.gof.creational.prototype;

import java.util.List;

/**
 * GoF's Pattern: Prototype
 * 
 * O padrão Prototype é referente a criação duplicada de objetos tendo performance em mente.
 * Esse padrão envolve a implementação de uma interface de protótipo que para criar um clone do
 * objeto corrente. Esse padrão é usado quando a criação de objeto diretamente "custa caro".
 * Por exemplo, um objeto deve ser criado depois de uma operação pesada no banco de dados.
 * Nós podemos fazer um cache do objeto, retornar seu clone na próxima requisição e atualizar o 
 * banco de dados como e quando necessário, reduzindo assim as chamadas de banco de dados.
 * 
 * Este tipo de design pattern é do tipo Creational Pattern e provê um dos melhores caminhos
 * para criar um objeto.
 * 
 * Cenário aplicável:
 */
public class FuncionarioTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		FuncionarioDAO func0 = new FuncionarioDAO();
		func0.cargaDados();

		// Use the clone method to get the Employee object
		// Usa o método clone para obter o objeto FuncionarioDAO
		FuncionarioDAO func1 = (FuncionarioDAO) func0.clone();
		FuncionarioDAO func2 = (FuncionarioDAO) func0.clone();
		
		List<String> list1 = func1.getFuncionarios();
		list1.add("John");
		
		List<String> list2 = func2.getFuncionarios();
		list2.remove("Pedro");

		System.out.println("Lista de funcionários [func0]: " + func0.getFuncionarios());
		System.out.println("Lista de funcionários [func1]: " + list1);
		System.out.println("Lista de funcionários [func2]: " + list2);
	}
}
