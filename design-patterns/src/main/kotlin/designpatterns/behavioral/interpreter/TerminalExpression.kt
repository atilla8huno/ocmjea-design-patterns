package designpatterns.behavioral.interpreter

class TerminalExpression(private val data: String) : Expression {
    override fun interpret(expression: String): Boolean = expression.contains(data)
}
