package designpatterns.behavioral.memento

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Memento (Behavioural)
 *
 * Capture and restore an object's state without exposing its internals.
 * Person writes a PersonMemento; PersonStates keeps the history. Undo
 * restores an earlier snapshot.
 *
 * Applicable for undo, checkpoints or draft versions. This test saves two
 * names, then restores the earlier one.
 */
class PersonTest {
    @Test
    fun `restores previously saved person names`() {
        val person = Person()
        val states = PersonStates()

        person.name = "First name..."

        person.name = "Second name..."
        states.add(person.saveStateToMemento())

        person.name = "Third name..."
        states.add(person.saveStateToMemento())

        person.name = "Fourth name..."
        assertEquals("Fourth name...", person.name)

        person.restoreNameFromMemento(states.get(0))
        assertEquals("Second name...", person.name)

        person.restoreNameFromMemento(states.get(1))
        assertEquals("Third name...", person.name)
    }
}
