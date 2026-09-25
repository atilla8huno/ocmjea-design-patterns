package solid.single_responsibility

class InvoicePrinter {
    fun print(invoice: Invoice) {
        println("Printing invoice ${invoice.number}: ${invoice.amount}")
    }
}
