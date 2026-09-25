package coroutines.launch

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * launch
 *
 * Start a coroutine that does not produce a value. launch returns a Job;
 * join() waits until that job finishes. The work runs in the same
 * coroutineScope, so structured concurrency cancels children if the parent
 * fails.
 *
 * Contrast with async, which returns a Deferred you await. This test runs
 * LaunchTask and checks the side-effect result after join.
 */
class LaunchTest {
    @Test
    fun `runs a launched task to completion`() = runBlocking {
        val result = LaunchTask().execute()

        assertEquals("Task completed", result)
    }
}
