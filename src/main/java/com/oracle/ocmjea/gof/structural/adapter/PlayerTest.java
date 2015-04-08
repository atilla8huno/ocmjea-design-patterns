package com.oracle.ocmjea.gof.structural.adapter;

/**
 * GoF's Pattern: Adapter
 * 
 * O padrão Adapter trabalha como uma ponte entre duas interfaces incompatíveis. Este tipo de design 
 * pattern é do tipo Structural Pattern, bem como combina a capacidade de duas interfaces independentes. 
 * 
 * Esse padrão envolve uma única classe que é responsável por unir funcionalidades de interfaces
 * incompatíveis ou independentes. 
 * Um exemplo real pode ser o caso de um leitor de cartão que atua como um adaptador entre um cartão
 * de memória e um notebook. Você pluga o cartão de memória em um leitor de cartão e o leitor de cartão
 * no notebook, então o cartão de memória poderá ser lido via notebook.
 * 
 * Cenário aplicável:
 */
public class PlayerTest {

	public static void main(String[] args) {
		
		AudioPlayer player = new AudioPlayer();
		
		player.play("mp3", "Fear of the dark.mp3");
		player.play("mp4", "Rammstein live aus Berlin.mp4");
		player.play("flv", "Policial americando matando um negro.flv");
		player.play("flac", "Música de alta qualidade.flac");
	}
}
