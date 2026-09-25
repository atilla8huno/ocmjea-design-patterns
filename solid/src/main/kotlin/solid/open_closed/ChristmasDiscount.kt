package solid.open_closed

class ChristmasDiscount : Discount {
    override fun apply(amount: Double) = amount * 0.9
}
