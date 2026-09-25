package designpatterns.behavioral.state

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers State by changing Context behaviour through Start and Stop. */
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
