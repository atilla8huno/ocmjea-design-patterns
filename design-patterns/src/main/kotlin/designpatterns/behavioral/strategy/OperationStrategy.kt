package designpatterns.behavioral.strategy

interface OperationStrategy {
    fun doOperation(num1: Int, num2: Int): Int
}
