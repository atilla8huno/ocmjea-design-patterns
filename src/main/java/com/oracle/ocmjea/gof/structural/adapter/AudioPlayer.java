package com.oracle.ocmjea.gof.structural.adapter;

public class AudioPlayer implements MediaPlayer {

	private MediaAdapter adapter;
	
	@Override
	public void play(String tipo, String arquivo) {
		switch (tipo) {
		case "mp3":
			System.out.println("Tocando arquivo MP3: " + arquivo);
			break;
		case "mp4":
			adapter = new MediaAdapter(tipo);
			adapter.play(tipo, arquivo);
			break;
		case "flv":
			adapter = new MediaAdapter(tipo);
			System.out.println("Tocando arquivo FLV: " + arquivo);
			break;
		default:
			System.out.println("Arquivo não suportado: " + arquivo);
			break;
		}
	}
}
