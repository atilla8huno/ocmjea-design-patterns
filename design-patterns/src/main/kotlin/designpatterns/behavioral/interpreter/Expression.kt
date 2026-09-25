package designpatterns.behavioral.interpreter

interface Expression {
    fun interpret(expression: String): Boolean
}
