package designpatterns.structural.decorator

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Decorator (Structural)
 *
 * Add behaviour by wrapping an object, without changing its class. The
 * decorator implements the same Shape interface and forwards to the inner
 * shape, then does extra work (here a blue border).
 *
 * Applicable when subclassing for every extra feature would explode. This
 * test draws a circle, then the same circle through BlueShapeDecorator.
 */
class ShapeTest {
    @Test
    fun `draws a circle and blue-decorated square and rectangle`() {
        val circle: Shape = Circle()
        val blueSquare: Shape = BlueShapeDecorator(Square())
        val blueRectangle: Shape = BlueShapeDecorator(Rectangle())

        assertDoesNotThrow {
            circle.draw()
            blueSquare.draw()
            blueRectangle.draw()
        }
    }
}
