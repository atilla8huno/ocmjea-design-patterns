package designpatterns.structural.flyweight

import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import kotlin.random.Random

/** Covers Flyweight by reusing Circle instances keyed by colour. */
class ShapeTest {
    @Test
    fun `reuses circles of the same colour`() {
        val colours = arrayOf("Red", "Green", "Blue", "White", "Black")

        repeat(20) {
            val circle = ShapeFactory.getCircle(colours[Random.nextInt(colours.size)]) as Circle
            circle.x = Random.nextInt(100)
            circle.y = Random.nextInt(100)
            circle.radius = 100
            circle.draw()
        }

        assertSame(ShapeFactory.getCircle("Red"), ShapeFactory.getCircle("Red"))
    }
}
