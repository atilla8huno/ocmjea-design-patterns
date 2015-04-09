package com.oracle.ocmjea.gof.behavioral.command;

/**
 * GoF's Pattern: Command
 * 
 * No padrão Command uma requisição é encapsulada (wrapped) em um objeto como comando e passado para um 
 * objeto invocador. O objeto invocador olha para o objeto apropriado que pode tratar esse comando e passa 
 * o comando para o objeto correspondente, que executa o comando.
 * 
 * Esse tipo de design pattern é do tipo Behavioral Pattern. É uma espécie de "dado guiado".
 * 
 * Cenário aplicável:
 */
public class FileTest {

	public static void main(String[] args) {
		
		// Criando um receptor de comandos
		FileSystemReceiver receptor = FileSystemReceiverUtil.getSistemaOperacionalDaMaquina();

		// Criando um comando e associonado-o com o receptor
		AbrirArquivoComando comandoAbrirArquivo = new AbrirArquivoComando(receptor);
		// Criando um invocador de comandos e associando-o com um comando
		ArquivoInvoker invocador = new ArquivoInvoker(comandoAbrirArquivo);
		// Executa a ação no objeto invocador
		invocador.execute();

		EscreverArquivoComando comandoEscreverArquivo = new EscreverArquivoComando(receptor);
		invocador = new ArquivoInvoker(comandoEscreverArquivo);
		invocador.execute();

		FecharArquivoComando comandoFecharArquivo = new FecharArquivoComando(receptor);
		invocador = new ArquivoInvoker(comandoFecharArquivo);
		invocador.execute();
	}
}
