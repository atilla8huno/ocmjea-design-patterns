package solid.interface_segregation

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers ISP by keeping work and feeding on separate interfaces. */
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
