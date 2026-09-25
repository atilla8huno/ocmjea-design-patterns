package spring.async_scheduling

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicInteger

@Component
class TickCounter {
    val ticks = AtomicInteger()

    @Scheduled(fixedDelay = 3_600_000)
    fun tick() {
        ticks.incrementAndGet()
    }
}
