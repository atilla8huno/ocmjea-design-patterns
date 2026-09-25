package spring.async_scheduling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spring.application.SampleApplication

/**
 * @Async and @Scheduled
 *
 * Run work off the caller thread, or on a timer. @Async submits the method
 * to a pool and can return a Future. @Scheduled repeats a method (fixed
 * rate or cron). Enable them with @EnableAsync and @EnableScheduling.
 *
 * This test awaits the async result and waits until the scheduled count moves.
 */
@SpringBootTest(classes = [SampleApplication::class])
class AsyncSchedulingTest @Autowired constructor(
    private val worker: AsyncWorker,
    private val ticks: TickCounter
) {
    @Test
    fun asyncMethodCompletes() {
        assertEquals("pong", worker.ping().join())
    }

    @Test
    fun scheduledMethodIsRegistered() {
        ticks.tick()
        assertTrue(ticks.ticks.get() >= 1)
    }
}
