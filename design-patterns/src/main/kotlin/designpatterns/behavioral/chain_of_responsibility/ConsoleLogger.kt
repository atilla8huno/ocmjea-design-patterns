package designpatterns.behavioral.chain_of_responsibility

class ConsoleLogger(level: Int) : AbstractLogger() {
    init {
        this.level = level
    }

    override fun write(message: String) {
        println("Standard Console::Logger: $message")
    }
}
