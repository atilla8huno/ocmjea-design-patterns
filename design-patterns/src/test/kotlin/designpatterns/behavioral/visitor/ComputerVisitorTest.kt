package designpatterns.behavioral.visitor

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Visitor (Behavioural)
 *
 * Add an operation to a structure without changing the element classes.
 * Each ComputerPart accept()s a ComputerPartVisitor; the visitor has a
 * visit method per part (keyboard, mouse, monitor, computer).
 *
 * Applicable when the object structure is stable but operations keep growing.
 * This test walks a Computer and displays each part.
 */
class ComputerVisitorTest {
    @Test
    fun `visits computer parts for display`() {
        val computer: ComputerPart = Computer()

        assertDoesNotThrow {
            computer.accept(ComputerPartDisplayVisitor())
        }
    }
}
