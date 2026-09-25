package coroutines.channel

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers Channel by transferring ordered values between coroutines. */
class ChannelTest {
    @Test
    fun `receives ordered values from a channel`() = runBlocking {
        val values = NumberChannel().receive()

        assertEquals(listOf(1, 2, 3), values)
    }
}
