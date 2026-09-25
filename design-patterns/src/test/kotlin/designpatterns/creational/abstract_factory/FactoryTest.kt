package designpatterns.creational.abstract_factory

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

/**
 * Abstract Factory (Creational)
 *
 * A factory of factories: one producer returns a factory for a whole family of
 * related products (shapes, or colours). Each factory creates those products
 * through a common interface, without naming the concrete classes.
 *
 * Applicable when families must stay consistent. This test takes a shape factory
 * and a colour factory from FactoryProducer, then draws and fills.
 */
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
