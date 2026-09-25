package coroutines.async

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers async by awaiting a Deferred calculation. */
class AsyncTest {
    @Test
    fun `adds numbers concurrently`() = runBlocking {
        val result = AsyncCalculator().add(20, 22)

        assertEquals(42, result)
    }
}
