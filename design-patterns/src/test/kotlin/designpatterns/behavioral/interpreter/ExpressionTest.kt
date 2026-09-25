package designpatterns.behavioral.interpreter

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/** Covers Interpreter by evaluating terminal, or, and and expressions. */
class ExpressionTest {
    @Test
    fun `interprets male and married woman expressions`() {
        val isMale = maleExpression()
        val isMarriedWoman = marriedWomanExpression()

        assertTrue(isMale.interpret("John"))
        assertTrue(isMarriedWoman.interpret("Married Julie"))
    }

    private fun maleExpression(): Expression {
        val robert = TerminalExpression("Robert")
        val john = TerminalExpression("John")
        return OrExpression(robert, john)
    }

    private fun marriedWomanExpression(): Expression {
        val julie = TerminalExpression("Julie")
        val married = TerminalExpression("Married")
        return AndExpression(julie, married)
    }
}
