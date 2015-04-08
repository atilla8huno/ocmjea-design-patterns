package com.oracle.ocmjea.gof.structural.adapter;

public class MediaAdapter implements MediaPlayer {

	private MediaPlayerAvancado playerAvancado;

	public MediaAdapter(String tipoAudio) {
		switch (tipoAudio) {
		case "flv":
			playerAvancado = new FlvPlayer();
		case "mp4":
			playerAvancado = new Mp4Player();
		}
	}

	@Override
	public void play(String tipo, String arquivo) {
		if (tipo.equalsIgnoreCase("flv")) {
			playerAvancado.playFlv(arquivo);
		} else if (tipo.equals("mp4")) {
			playerAvancado.playMp4(arquivo);
		}
	}
}
