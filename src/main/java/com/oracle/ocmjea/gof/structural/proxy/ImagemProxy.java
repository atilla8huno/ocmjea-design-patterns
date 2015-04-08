package com.oracle.ocmjea.gof.structural.proxy;

public class ImagemProxy implements Imagem {

	private ImagemReal imagemReal;
	private String fileName;

	public ImagemProxy(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		if (imagemReal == null) {
			imagemReal = new ImagemReal(fileName);
		}
		imagemReal.display();
	}
}
