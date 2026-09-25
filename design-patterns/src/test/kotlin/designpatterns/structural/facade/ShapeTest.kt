package designpatterns.structural.facade

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Facade (Structural)
 *
 * Hide a subsystem behind one simple API. ShapeFacade knows Circle, Square
 * and Rectangle; the client calls drawAll() (or similar) and never constructs
 * those types itself.
 *
 * Applicable when a handful of classes are always used together. This test
 * draws the three shapes through ShapeFacade.
 */
class ShapeTest {
    @Test
    fun `draws circle square and rectangle via the facade`() {
        val shaper = ShapeFacade()

        assertDoesNotThrow {
            shaper.drawCircle()
            shaper.drawSquare()
            shaper.drawRectangle()
        }
    }
}
