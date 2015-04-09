package com.oracle.ocmjea.gof.behavioral.command;

public class FecharArquivoComando implements Comando {

	private FileSystemReceiver fileSystem;

	public FecharArquivoComando(FileSystemReceiver fs) {
		this.fileSystem = fs;
	}

	@Override
	public void execute() {
		// O comando close está redirecionando a requisição para o método closeFile()
		this.fileSystem.closeFile();
	}
}
