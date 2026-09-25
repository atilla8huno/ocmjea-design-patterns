package designpatterns.creational.abstract_factory

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

/** Covers Abstract Factory by creating related shape and colour products. */
class FactoryTest {
    @Test
    fun `creates shapes and colours from produced factories`() {
        val shapeFactory = FactoryProducer.getFactory("shape")
        val colourFactory = FactoryProducer.getFactory("colour")

        assertNotNull(shapeFactory)
        assertNotNull(colourFactory)

        assertDoesNotThrow {
            shapeFactory?.getShape("square")?.draw()
            shapeFactory?.getShape("circle")?.draw()
            colourFactory?.getColour("blue")?.fill()
            colourFactory?.getColour("red")?.fill()
        }
    }
}
