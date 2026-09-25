package solid.open_closed

interface Discount {
    fun apply(amount: Double): Double
}
