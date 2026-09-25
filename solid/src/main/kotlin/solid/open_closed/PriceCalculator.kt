package solid.open_closed

class PriceCalculator(private val discount: Discount) {
    fun finalPrice(amount: Double): Double = discount.apply(amount)
}
