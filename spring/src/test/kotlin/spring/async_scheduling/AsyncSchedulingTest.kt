package spring.async_scheduling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spring.application.SampleApplication

/** @Async returns a future and @Scheduled increments a counter. */
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
