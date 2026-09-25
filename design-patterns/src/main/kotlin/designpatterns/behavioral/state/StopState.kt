package designpatterns.behavioral.state

class StopState : State {
    override fun doAction(context: Context) {
        println("Moving to the STOPPED state")
        context.state = this
    }

    override fun toString() = "State: Stop"
}
