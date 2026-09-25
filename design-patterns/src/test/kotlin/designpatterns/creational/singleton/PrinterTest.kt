package designpatterns.creational.singleton

import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

/**
 * Singleton (Creational)
 *
 * One class is responsible for creating its only instance and for handing that
 * instance out. Callers never construct it; they resolve UniquePrinter and
 * always get the same object.
 *
 * Applicable when a shared resource must exist exactly once. This test
 * resolves the printer twice and checks both references are the same.
 */
class PrinterTest {
    @Test
    fun `returns the same printer instance`() {
        val printer = UniquePrinter
        printer.print("Credit card statement - April/2015")

        val samePrinter = UniquePrinter
        samePrinter.print("\nCredit card statement - May/2015")

        assertSame(printer, samePrinter)
    }
}
