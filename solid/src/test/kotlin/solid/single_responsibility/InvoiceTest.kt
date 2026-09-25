package solid.single_responsibility

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Single Responsibility
 *
 * A class should have one reason to change. Invoice data, persistence and
 * printing would otherwise live together; a change to any of those jobs
 * would touch the same type.
 *
 * Invoice holds number and amount, InvoiceRepository saves, InvoicePrinter
 * prints. This test uses each type for one job.
 */
class InvoiceTest {
    @Test
    fun `saves and prints an invoice`() {
        val invoice = Invoice("INV-001", 150.0)

        assertEquals("INV-001", invoice.number)
        assertEquals(150.0, invoice.amount)
        assertDoesNotThrow {
            InvoiceRepository().save(invoice)
            InvoicePrinter().print(invoice)
        }
    }
}
