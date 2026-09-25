package coroutines.async

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * async
 *
 * Start a coroutine that produces a result. async returns a Deferred;
 * await() suspends until the value is ready and unwraps it. Several
 * async blocks can run concurrently, then you await each.
 *
 * Unlike launch + join, which only wait for completion. This test adds
 * two numbers through AsyncCalculator.
 */
class AsyncTest {
    @Test
    fun `adds numbers concurrently`() = runBlocking {
        val result = AsyncCalculator().add(20, 22)

        assertEquals(42, result)
    }
}
