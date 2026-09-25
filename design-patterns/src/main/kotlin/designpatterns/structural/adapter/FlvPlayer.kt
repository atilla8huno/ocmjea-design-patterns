package designpatterns.structural.adapter

class FlvPlayer : AdvancedMediaPlayer {
    override fun playMp4(fileName: String) {
    }

    override fun playFlv(fileName: String) {
        println("Playing FLV file: $fileName")
    }
}
