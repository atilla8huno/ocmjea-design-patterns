package solid.dependency_inversion

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

/**
 * Dependency Inversion
 *
 * High-level policy should not depend on low-level details; both depend on
 * an abstraction. Switch talks to Switchable, not to Lamp or Fan. New
 * devices plug in without changing Switch.
 *
 * This test turns a lamp and a fan on and off through the same Switch.
 */
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
