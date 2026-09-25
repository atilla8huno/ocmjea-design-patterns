package designpatterns.behavioral.template_method

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/** Covers Template Method by playing games through the shared Game path. */
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
