package designpatterns.behavioral.iterator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Iterator (Behavioural)
 *
 * Walk a collection without exposing its storage. NameDAO is a Container;
 * CollectionIterator offers hasNext and next so the client never sees the
 * array or list inside.
 *
 * Applicable whenever traversal should stay independent of the data structure.
 * This test prints each name through that iterator.
 */
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
