package designpatterns.structural.bridge

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Bridge (Structural)
 *
 * Split an abstraction from its implementation so they vary independently.
 * Circle holds size; DrawingAPI (blue, green) does the actual draw. You can
 * mix any circle with any colour API without a class explosion.
 *
 * Applicable when two dimensions of change would otherwise multiply subclasses.
 * This test draws two circles, each with a different colour implementer.
 */
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
