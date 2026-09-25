package solid.open_closed

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Open/Closed
 *
 * Open for extension, closed for modification. New pricing rules should be
 * new Discount types, not edits to PriceCalculator. The calculator only
 * asks the current Discount for the final price.
 *
 * Applicable when a family of algorithms will grow. This test swaps
 * NoDiscount, ChristmasDiscount and BlackFridayDiscount.
 */
class PriceCalculatorTest {
    @Test
    fun `applies no discount christmas and black friday prices`() {
        val amount = 100.0

        assertEquals(100.0, PriceCalculator(NoDiscount()).finalPrice(amount))
        assertEquals(90.0, PriceCalculator(ChristmasDiscount()).finalPrice(amount))
        assertEquals(70.0, PriceCalculator(BlackFridayDiscount()).finalPrice(amount))
    }
}
