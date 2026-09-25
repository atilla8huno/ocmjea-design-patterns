package designpatterns.structural.adapter

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Adapter (Structural)
 *
 * A bridge between two incompatible interfaces. AudioPlayer only plays mp3;
 * MediaAdapter wraps the mp4 and flv players so the same play() call works
 * for all three. The client never talks to the extra players directly.
 *
 * Applicable when you cannot change an existing API but must use another one.
 * This test plays mp3, mp4 and flv through AudioPlayer.
 */
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
