package designpatterns.structural.adapter

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/** Covers Adapter by playing mixed media types through AudioPlayer. */
class PlayerTest {
    @Test
    fun `plays supported formats and reports unsupported files`() {
        val player = AudioPlayer()

        assertDoesNotThrow {
            player.play("mp3", "Fear of the dark.mp3")
            player.play("mp4", "Rammstein live aus Berlin.mp4")
            player.play("flv", "Holiday video.flv")
            player.play("flac", "High quality song.flac")
        }
    }
}
