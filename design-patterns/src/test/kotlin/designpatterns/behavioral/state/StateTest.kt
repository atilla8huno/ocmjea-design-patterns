package designpatterns.behavioral.state

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * State (Behavioural)
 *
 * Change behaviour by swapping the object that represents the current mode.
 * Context holds a State and delegates to it. StartState and StopState each
 * implement one mode, so Context has no flag or switch.
 *
 * Applicable when an object has a few well-defined modes. This test moves
 * from StartState to StopState.
 */
class StateTest {
    @Test
    fun `transitions context from start to stop`() {
        val context = Context()

        StartState().doAction(context)
        assertEquals("State: Start", context.state.toString())

        StopState().doAction(context)
        assertEquals("State: Stop", context.state.toString())
    }
}
