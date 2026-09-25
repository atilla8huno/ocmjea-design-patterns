package designpatterns.creational.factory_method

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test

/** Covers Factory Method by creating birds through BirdFactory. */
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
