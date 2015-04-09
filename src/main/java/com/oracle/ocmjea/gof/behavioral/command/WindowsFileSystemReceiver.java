package com.oracle.ocmjea.gof.behavioral.command;

public class WindowsFileSystemReceiver implements FileSystemReceiver {

	@Override
	public void openFile() {
		System.out.println("Abrindo arquivo em um windows OS");
	}

	@Override
	public void writeFile() {
		System.out.println("Escrevendo arquivo em um windows OS");
	}

	@Override
	public void closeFile() {
		System.out.println("Fechando arquivo em um windows OS");
	}
}
