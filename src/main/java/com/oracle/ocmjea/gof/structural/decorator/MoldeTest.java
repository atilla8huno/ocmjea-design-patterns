package com.oracle.ocmjea.gof.structural.decorator;

/**
 * GoF's Pattern: Decorator
 * 
 * O padrão Decorator permite que um usuário adicione nova funcionalidade para um objeto existente
 * sem alterar sua construção. Esse tipo de design pattern é do tipo Structural Pattern, bem como
 * este padrão atua como um wrapper para uma classe existente.
 * 
 * Este padrão cria uma classe decorator que faz um wrapper da classe original e provê funcionalidades
 * adicionais, mantendo as assinaturas dos métodos intactas.
 * 
 * Cenário aplicável:
 */
public class MoldeTest {

	public static void main(String[] args) {
		Molde circulo = new Circulo();
		
		Molde quadradoAzul = new MoldeAzulDecorator(new Quadrado());
		
		Molde retanguloAzul = new MoldeAzulDecorator(new Retangulo());
		
		System.out.println("Círculo normal");
		circulo.desenhar();

		System.out.println("\nQuadrado azul");
		quadradoAzul.desenhar();
		
		System.out.println("\nRetangulo azul");
		retanguloAzul.desenhar();
	}
}
