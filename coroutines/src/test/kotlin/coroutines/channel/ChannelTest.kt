package coroutines.channel

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Channel
 *
 * A live pipe between coroutines. send waits for receive (rendezvous unless
 * you pick a buffered channel). close() ends the stream; a for-loop on the
 * channel stops after that.
 *
 * Flow is cold and restarts per collector. This test sends 1..3 and reads
 * them in order after close.
 */
class ChannelTest {
    @Test
    fun `receives ordered values from a channel`() = runBlocking {
        val values = NumberChannel().receive()

        assertEquals(listOf(1, 2, 3), values)
    }
}
