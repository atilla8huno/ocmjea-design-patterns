package coroutines.cancel

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/** Covers cooperative cancellation of a launched Job. */
class CancelTest {
    @Test
    fun `cancels a job and waits for cleanup`() = runBlocking {
        val job = launch {
            CancellableTask().execute()
        }
        job.cancelAndJoin()

        assertTrue(job.isCancelled)
    }
}
