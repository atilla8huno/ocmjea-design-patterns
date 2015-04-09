package com.oracle.ocmjea.gof.behavioral.visitor;

/**
 * GoF's Pattern: Visitor
 * 
 * No padrão Visitor, nós usamos uma classe visitante que altera o algoritmo de execução de uma element class.
 * Desta forma, a execução do algoritmo do elemento pode variar como e quando o visitor varia.
 * Como por padrão, o objeto de elemento tem que aceitar o objeto visitor, então o objeto visitor processa a 
 * operação no element object.
 * 
 * Esse tipo de design pattern é do tipo Behavioral Pattern.
 * 
 * Cenário aplicável:
 */
public class ComputerVisitorTest {

	public static void main(String[] args) {
		
		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
	}
}
