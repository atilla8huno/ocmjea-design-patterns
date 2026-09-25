package designpatterns.structural.bridge

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/** Covers Bridge by drawing circles with independent colour implementers. */
class DrawingTest {
    @Test
    fun `draws blue and green circles through the bridge`() {
        val blueCircle: Shape = Circle(100, 100, 10, BlueCircle())
        val greenCircle: Shape = Circle(80, 80, 8, GreenCircle())

        assertDoesNotThrow {
            blueCircle.draw()
            greenCircle.draw()
        }
    }
}
