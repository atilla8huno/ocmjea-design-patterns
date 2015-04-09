package com.oracle.ocmjea.gof.behavioral.command;

public class UnixFileSystemReceiver implements FileSystemReceiver {

	@Override
	public void openFile() {
		System.out.println("Abrindo arquivo em um unix OS");
	}

	@Override
	public void writeFile() {
		System.out.println("Escrevendo arquivo em um unix OS");
	}

	@Override
	public void closeFile() {
		System.out.println("Fechando arquivo em um unix OS");
	}
}
