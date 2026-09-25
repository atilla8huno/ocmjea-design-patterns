package designpatterns.behavioral.chain_of_responsibility

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/** Covers Chain of Responsibility by forwarding log messages down logger levels. */
class LoggerTest {
    @Test
    fun `logs info debug and error through the chain`() {
        val loggerChain = chainOfLoggers()

        assertDoesNotThrow {
            loggerChain.logMessage(AbstractLogger.INFO, "This is an information.")
            loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug level information.")
            loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.")
        }
    }

    private fun chainOfLoggers(): AbstractLogger {
        val errorLogger = ErrorLogger(AbstractLogger.ERROR)
        val fileLogger = FileLogger(AbstractLogger.DEBUG)
        val consoleLogger = ConsoleLogger(AbstractLogger.INFO)

        errorLogger.setNextLogger(fileLogger)
        fileLogger.setNextLogger(consoleLogger)

        return errorLogger
    }
}
