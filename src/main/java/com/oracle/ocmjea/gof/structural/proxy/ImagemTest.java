package com.oracle.ocmjea.gof.structural.proxy;

/**
 * GoF's Pattern: Proxy
 * 
 * No padrão Proxy, uma classe representa funcionalidades de outra classe. Nós criamos objetos
 * tendo um objeto original para 'interfacear' suas funcionalidades para o mundo externo.
 * 
 * Esse tipo de design pattern é do tipo Structural Pattern.
 * 
 * Cenário aplicável:
 */
public class ImagemTest {

	public static void main(String[] args) {
		
		Imagem imagem = new ImagemProxy("teste_10mb.jpg");

		// imagem será carregada do disco
		imagem.display();
		System.out.println("");

		// imagem NÃO será carregada do disco
		imagem.display();
	}
}
