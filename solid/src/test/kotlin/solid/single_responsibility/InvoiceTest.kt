package solid.single_responsibility

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers SRP by keeping invoice data separate from persistence and printing. */
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
