package designpatterns.structural.adapter

class Mp4Player : AdvancedMediaPlayer {
    override fun playMp4(fileName: String) {
        println("Playing MP4 file: $fileName")
    }

    override fun playFlv(fileName: String) {
    }
}
