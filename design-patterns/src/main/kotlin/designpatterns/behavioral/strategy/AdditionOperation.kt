package designpatterns.behavioral.strategy

class AdditionOperation : OperationStrategy {
    override fun doOperation(num1: Int, num2: Int) = num1 + num2
}
