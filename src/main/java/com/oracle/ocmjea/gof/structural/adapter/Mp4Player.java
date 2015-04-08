package com.oracle.ocmjea.gof.structural.adapter;

public class Mp4Player implements MediaPlayerAvancado {

	@Override
	public void playMp4(String arquivo) {
		System.out.println("Tocando arquivo MP4: " + arquivo);
	}

	@Override
	public void playFlv(String arquivo) {
		// do nothing
	}
}
