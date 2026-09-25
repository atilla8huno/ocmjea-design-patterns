package designpatterns.behavioral.chain_of_responsibility

class FileLogger(level: Int) : AbstractLogger() {
    init {
        this.level = level
    }

    override fun write(message: String) {
        println("File::Logger: $message")
    }
}
