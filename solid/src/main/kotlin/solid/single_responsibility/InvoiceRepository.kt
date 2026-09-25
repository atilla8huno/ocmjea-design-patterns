package solid.single_responsibility

class InvoiceRepository {
    fun save(invoice: Invoice) {
        println("Saving invoice ${invoice.number} for ${invoice.amount}")
    }
}
