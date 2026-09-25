package designpatterns.behavioral.chain_of_responsibility

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Chain of Responsibility (Behavioural)
 *
 * Pass a request along a chain of handlers. Each logger has a level: it
 * writes the message if it can, then forwards to the next. The sender does
 * not know which handler will process it.
 *
 * Applicable when several objects might handle a request. This test sends
 * info, debug and error messages down the logger chain.
 */
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
