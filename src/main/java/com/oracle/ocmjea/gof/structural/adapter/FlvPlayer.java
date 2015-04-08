package com.oracle.ocmjea.gof.structural.adapter;

public class FlvPlayer implements MediaPlayerAvancado {

	@Override
	public void playMp4(String arquivo) {
		// do nothing
	}

	@Override
	public void playFlv(String arquivo) {
		System.out.println("Tocando arquivo FLV: " + arquivo);
	}
}
