package coroutines.launch

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers launch by starting work that completes as a Job. */
class LaunchTest {
    @Test
    fun `runs a launched task to completion`() = runBlocking {
        val result = LaunchTask().execute()

        assertEquals("Task completed", result)
    }
}
