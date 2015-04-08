package com.oracle.ocmjea.gof.structural.proxy;

public class ImagemReal implements Imagem {

	private String fileName;

	public ImagemReal(String fileName) {
		this.fileName = fileName;
		carregarDoDisco(fileName);
	}

	@Override
	public void display() {
		System.out.println("Exibindo " + fileName);
	}

	private void carregarDoDisco(String fileName) {
		System.out.println("Carregando " + fileName);
	}
}
