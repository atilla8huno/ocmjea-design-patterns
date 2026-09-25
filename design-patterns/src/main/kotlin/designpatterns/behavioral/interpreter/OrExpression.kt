package designpatterns.behavioral.interpreter

class OrExpression(
    private val expression1: Expression,
    private val expression2: Expression
) : Expression {
    override fun interpret(expression: String): Boolean =
        expression1.interpret(expression) || expression2.interpret(expression)
}
