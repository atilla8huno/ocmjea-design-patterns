package designpatterns.creational.singleton

import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

/** Covers Singleton by resolving UniquePrinter to one shared instance. */
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
