package designpatterns.structural.facade

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/** Covers Facade by drawing shapes through ShapeFacade. */
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
