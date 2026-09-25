package designpatterns.creational.factory_method

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test

/**
 * Factory Method (Creational)
 *
 * Create objects without exposing constructors to the caller. The factory
 * decides the concrete type and returns it through a common interface (Bird).
 * The client depends on that interface, not on Eagle, Hawk or Parrot.
 *
 * Applicable when the caller should not know which class to new up. This test
 * asks BirdFactory for the three birds and checks they can fly.
 */
class BirdFactoryTest {
    @Test
    fun `creates eagle hawk and parrot without exposing constructors`() {
        val eagle = BirdFactory.getBird("Eagle")
        val hawk = BirdFactory.getBird("Hawk")
        val parrot = BirdFactory.getBird("Parrot")

        assertInstanceOf(Eagle::class.java, eagle)
        assertInstanceOf(Hawk::class.java, hawk)
        assertInstanceOf(Parrot::class.java, parrot)

        assertDoesNotThrow {
            eagle?.fly()
            hawk?.fly()
            parrot?.fly()
        }
    }
}
