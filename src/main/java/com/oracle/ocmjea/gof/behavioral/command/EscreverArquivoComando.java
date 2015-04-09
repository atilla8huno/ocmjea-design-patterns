package com.oracle.ocmjea.gof.behavioral.command;

public class EscreverArquivoComando implements Comando {

	private FileSystemReceiver fileSystem;

	public EscreverArquivoComando(FileSystemReceiver fs) {
		this.fileSystem = fs;
	}

	@Override
	public void execute() {
		// O comando write está redirecionando a requisição para o método writeFile()
		this.fileSystem.writeFile();
	}
}
