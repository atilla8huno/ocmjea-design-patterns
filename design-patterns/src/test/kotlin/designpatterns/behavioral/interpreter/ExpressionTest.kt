package designpatterns.behavioral.interpreter

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Interpreter (Behavioural)
 *
 * Represent a small grammar as an object tree and evaluate it. Terminal
 * expressions match a literal; And and Or combine them. The client builds
 * the tree and calls interpret() on the root.
 *
 * Applicable for simple rules, not a full language. This test checks who is
 * a man, a married woman, or John/Julie.
 */
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
