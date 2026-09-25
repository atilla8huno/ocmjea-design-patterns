package designpatterns.behavioral.strategy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Strategy (Behavioural)
 *
 * Change an algorithm at runtime without changing the caller. Each algorithm is
 * an object behind one interface; a Context holds the current strategy and
 * forwards the request to it. That replaces a switch on the operation type.
 *
 * Applicable when several algorithms are interchangeable. This test swaps
 * multiplication, addition and subtraction on Context.
 */
class OperationTest {
    @Test
    fun `executes multiplication addition and subtraction strategies`() {
        var context = Context(MultiplicationOperation())
        assertEquals(100, context.executeStrategy(10, 10))

        context = Context(AdditionOperation())
        assertEquals(15, context.executeStrategy(10, 5))

        context = Context(SubtractionOperation())
        assertEquals(15, context.executeStrategy(18, 3))
    }
}
