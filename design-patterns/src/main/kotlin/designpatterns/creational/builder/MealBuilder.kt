package designpatterns.creational.builder

class MealBuilder {
    fun prepareBeefBurgerCombo(): Meal {
        val meal = Meal()
        meal.addItem(BeefBurger())
        meal.addItem(CocaCola())
        return meal
    }

    fun prepareBeefBurger(): Meal {
        val meal = Meal()
        meal.addItem(BeefBurger())
        return meal
    }

    fun prepareChickenBurgerCombo(): Meal {
        val meal = Meal()
        meal.addItem(BeefBurger())
        meal.addItem(CocaCola())
        return meal
    }

    fun prepareChickenBurgerComboWithPepsi(): Meal {
        val meal = Meal()
        meal.addItem(ChickenBurger())
        meal.addItem(Pepsi())
        return meal
    }
}
