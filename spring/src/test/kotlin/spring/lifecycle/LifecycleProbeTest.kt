package spring.lifecycle

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spring.application.SampleApplication

/**
 * Bean lifecycle
 *
 * After construction and injection, Spring calls @PostConstruct. That is
 * the place for one-off setup that needs the collaborators already there
 * (opening a connection, warming a cache).
 *
 * This test checks the probe ran that callback.
 */
@SpringBootTest(classes = [SampleApplication::class])
class LifecycleProbeTest @Autowired constructor(
    private val probe: LifecycleProbe
) {
    @Test
    fun startsAfterConstruction() {
        assertTrue(probe.started)
    }
}
