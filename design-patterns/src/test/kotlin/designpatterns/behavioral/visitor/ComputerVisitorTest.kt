package designpatterns.behavioral.visitor

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/** Covers Visitor by accepting a display visitor on Computer parts. */
class ComputerVisitorTest {
    @Test
    fun `visits computer parts for display`() {
        val computer: ComputerPart = Computer()

        assertDoesNotThrow {
            computer.accept(ComputerPartDisplayVisitor())
        }
    }
}
