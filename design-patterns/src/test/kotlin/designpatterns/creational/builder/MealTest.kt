package designpatterns.creational.builder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Builder (Creational)
 *
 * Assemble a complex object step by step instead of a constructor with many
 * arguments. MealBuilder knows the recipe; the Meal only holds the finished
 * items and the total.
 *
 * Applicable when the same product has a few preset combinations. This test
 * builds two combos and a standalone burger and checks the totals.
 */
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
