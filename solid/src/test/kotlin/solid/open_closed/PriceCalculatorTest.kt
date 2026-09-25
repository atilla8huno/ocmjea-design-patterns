package solid.open_closed

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers OCP by applying Discount implementations without changing PriceCalculator. */
class PriceCalculatorTest {
    @Test
    fun `applies no discount christmas and black friday prices`() {
        val amount = 100.0

        assertEquals(100.0, PriceCalculator(NoDiscount()).finalPrice(amount))
        assertEquals(90.0, PriceCalculator(ChristmasDiscount()).finalPrice(amount))
        assertEquals(70.0, PriceCalculator(BlackFridayDiscount()).finalPrice(amount))
    }
}
