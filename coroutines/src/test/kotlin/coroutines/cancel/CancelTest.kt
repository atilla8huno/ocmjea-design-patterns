package coroutines.cancel

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Cancellation
 *
 * Coroutine cancel is cooperative: the job is marked cancelled and
 * suspends throw CancellationException. cancelAndJoin() requests cancel
 * then join()s so cleanup has finished before you inspect the job.
 *
 * It is not preemptive like Thread.stop. This test launches CancellableTask
 * and checks isCancelled after cancelAndJoin.
 */
class CancelTest {
    @Test
    fun `cancels a job and waits for cleanup`() = runBlocking {
        val job = launch {
            CancellableTask().execute()
        }
        job.cancelAndJoin() // cancel, then join so cleanup has finished

        assertTrue(job.isCancelled)
    }
}
