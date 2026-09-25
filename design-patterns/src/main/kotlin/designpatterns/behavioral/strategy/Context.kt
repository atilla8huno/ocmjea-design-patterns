package designpatterns.behavioral.strategy

class Context(private val strategy: OperationStrategy) {
    fun executeStrategy(num1: Int, num2: Int): Int = strategy.doOperation(num1, num2)
}
