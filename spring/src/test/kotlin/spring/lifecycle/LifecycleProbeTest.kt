package spring.lifecycle

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spring.application.SampleApplication

/** @PostConstruct runs when the bean is created. */
@SpringBootTest(classes = [SampleApplication::class])
class LifecycleProbeTest @Autowired constructor(
    private val probe: LifecycleProbe
) {
    @Test
    fun startsAfterConstruction() {
        assertTrue(probe.started)
    }
}
