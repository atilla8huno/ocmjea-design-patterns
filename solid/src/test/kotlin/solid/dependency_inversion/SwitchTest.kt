package solid.dependency_inversion

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/** Covers DIP by driving Switch through Switchable devices. */
class SwitchTest {
    @Test
    fun `toggles lamp and fan through the same switch`() {
        assertDoesNotThrow {
            val lampSwitch = Switch(Lamp())
            lampSwitch.pressOn()
            lampSwitch.pressOff()

            val fanSwitch = Switch(Fan())
            fanSwitch.pressOn()
            fanSwitch.pressOff()
        }
    }
}
