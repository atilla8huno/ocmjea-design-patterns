package designpatterns.behavioral.state

class StartState : State {
    override fun doAction(context: Context) {
        println("Moving to the STARTED state")
        context.state = this
    }

    override fun toString() = "State: Start"
}
