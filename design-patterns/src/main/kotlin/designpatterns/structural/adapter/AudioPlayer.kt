package designpatterns.structural.adapter

class AudioPlayer : MediaPlayer {
    private var adapter: MediaAdapter? = null

    override fun play(type: String, fileName: String) {
        when (type) {
            "mp3" -> println("Playing MP3 file: $fileName")
            "mp4" -> {
                adapter = MediaAdapter(type)
                adapter?.play(type, fileName)
            }
            "flv" -> {
                adapter = MediaAdapter(type)
                println("Playing FLV file: $fileName")
            }
            else -> println("Unsupported file: $fileName")
        }
    }
}
