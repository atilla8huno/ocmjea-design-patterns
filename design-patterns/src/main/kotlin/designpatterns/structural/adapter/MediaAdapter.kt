package designpatterns.structural.adapter

class MediaAdapter(audioType: String) : MediaPlayer {
    private val advancedPlayer: AdvancedMediaPlayer? = when (audioType) {
        "flv" -> FlvPlayer()
        "mp4" -> Mp4Player()
        else -> null
    }

    override fun play(type: String, fileName: String) {
        if (type.equals("flv", ignoreCase = true)) {
            advancedPlayer?.playFlv(fileName)
        } else if (type == "mp4") {
            advancedPlayer?.playMp4(fileName)
        }
    }
}
