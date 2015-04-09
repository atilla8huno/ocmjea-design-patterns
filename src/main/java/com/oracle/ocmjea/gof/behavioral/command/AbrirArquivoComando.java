package com.oracle.ocmjea.gof.behavioral.command;

public class AbrirArquivoComando implements Comando {

	private FileSystemReceiver fileSystem;

	public AbrirArquivoComando(FileSystemReceiver fs) {
		this.fileSystem = fs;
	}

	@Override
	public void execute() {
		// O comando open está redirecionando a requisição para o método openFile()
		this.fileSystem.openFile();
	}
}
