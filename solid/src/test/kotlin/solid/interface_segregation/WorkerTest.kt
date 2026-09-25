package solid.interface_segregation

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Interface Segregation
 *
 * Clients should not depend on methods they do not use. A single fat
 * Worker interface would force Robot to implement eat(). Split Workable
 * and Feedable so each type takes only what it needs.
 *
 * Human implements both; Robot only works. This test drives them through
 * those interfaces.
 */
class WorkerTest {
    @Test
    fun `human works and eats while robot only works`() {
        val human = Human()
        val robot = Robot()
        val workers: List<Workable> = listOf(human, robot)
        val diner: Feedable = human

        assertEquals(2, workers.size)
        assertDoesNotThrow {
            workers.forEach { it.work() }
            diner.eat()
        }
    }
}
