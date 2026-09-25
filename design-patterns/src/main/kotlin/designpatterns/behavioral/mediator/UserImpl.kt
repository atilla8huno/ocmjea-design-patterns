package designpatterns.behavioral.mediator

class UserImpl(name: String, mediator: ChatMediator) : User(name, mediator) {
    init {
        mediator.addUser(this)
    }

    override fun send(msg: String) {
        println("$name sending message: $msg")
        mediator.sendMessage(msg, this)
    }

    override fun receive(msg: String) {
        println("$name receiving message: $msg")
    }
}
