package solid.open_closed

class NoDiscount : Discount {
    override fun apply(amount: Double) = amount
}
