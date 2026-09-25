package solid.open_closed

class BlackFridayDiscount : Discount {
    override fun apply(amount: Double) = amount * 0.7
}
