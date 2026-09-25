package designpatterns.behavioral.template_method

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Template Method (Behavioural)
 *
 * Fix the steps of an algorithm in a base class and let subclasses fill some
 * of them. Game.play() always runs start, play and end; Fifa15 and
 * ShadowOfMordor override those hooks.
 *
 * Applicable when several types share a skeleton but differ in the details.
 * This test plays both games through that shared path.
 */
class ConsoleGameTest {
    @Test
    fun `plays fifa and shadow of mordor through the same template`() {
        assertDoesNotThrow {
            val fifa15: Game = Fifa15()
            fifa15.play()

            val mordor: Game = ShadowOfMordor()
            mordor.play()
        }
    }
}
