package designpatterns.structural.decorator

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/** Covers Decorator by wrapping shapes with BlueShapeDecorator. */
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
