package designpatterns.creational.builder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers Builder by assembling meal combos and a standalone burger. */
class MealTest {
    @Test
    fun `builds combos and a beef burger with expected totals`() {
        val builder = MealBuilder()

        val beefCombo = builder.prepareBeefBurgerCombo()
        beefCombo.showItems()
        assertEquals(10.5, beefCombo.getTotal())

        val chickenCombo = builder.prepareChickenBurgerComboWithPepsi()
        chickenCombo.showItems()
        assertEquals(9.0, chickenCombo.getTotal())

        val beefBurger = builder.prepareBeefBurger()
        beefBurger.showItems()
        assertEquals(6.0, beefBurger.getTotal())
    }
}
