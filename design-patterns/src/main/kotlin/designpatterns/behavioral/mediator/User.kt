package designpatterns.behavioral.mediator

abstract class User(
    protected val name: String,
    protected val mediator: ChatMediator
) {
    abstract fun send(msg: String)
    abstract fun receive(msg: String)
}
