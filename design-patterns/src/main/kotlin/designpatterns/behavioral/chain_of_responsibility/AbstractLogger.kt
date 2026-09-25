package designpatterns.behavioral.chain_of_responsibility

abstract class AbstractLogger {
    companion object {
        const val INFO = 1
        const val DEBUG = 2
        const val ERROR = 3
    }

    protected var level: Int = 0
    private var nextLogger: AbstractLogger? = null

    fun setNextLogger(nextLogger: AbstractLogger) {
        this.nextLogger = nextLogger
    }

    fun logMessage(level: Int, message: String) {
        if (this.level <= level) {
            write(message)
        }
        nextLogger?.logMessage(level, message)
    }

    protected abstract fun write(message: String)
}
