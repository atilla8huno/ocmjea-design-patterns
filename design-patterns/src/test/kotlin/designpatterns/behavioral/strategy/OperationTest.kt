package designpatterns.behavioral.strategy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers Strategy by swapping arithmetic operations on Context. */
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
