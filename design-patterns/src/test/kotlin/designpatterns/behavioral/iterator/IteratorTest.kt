package designpatterns.behavioral.iterator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers Iterator by walking NameDAO without exposing storage. */
class IteratorTest {
    @Test
    fun `iterates names in insertion order`() {
        val nameDAO = NameDAO()
        val names = mutableListOf<String>()
        val iter = nameDAO.getIterator()
        while (iter.hasNext()) {
            names.add(iter.next() as String)
        }

        assertEquals(listOf("Atilla", "Ben-Hur", "Jullierme", "Lucio"), names)
    }
}
