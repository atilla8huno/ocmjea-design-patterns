package collections.list;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Problem: expose a read-only catalogue and locate a value in it without scanning every element.
 *
 * List fits because it is an ordered, index-addressable view, so a sorted list supports binary
 * search while callers cannot modify it. List.of is the usual read-only catalogue.
 */
class ListTest {
    @Test
    void findsAValueByBinarySearch() {
        List<Integer> ids = List.of(2, 5, 8, 13, 21);

        assertEquals(3, Collections.binarySearch(ids, 13));
        assertTrue(Collections.binarySearch(ids, 6) < 0);
    }

    @Test
    void readsByPositionAndIndex() {
        List<String> languages = List.of("Kotlin", "Java", "Scala");

        assertEquals("Kotlin", languages.getFirst());
        assertEquals(1, languages.indexOf("Java"));
        assertEquals("Scala", languages.get(2));
    }

    @Test
    void indexAccessFailsOutsideTheList() {
        List<String> languages = List.of("Kotlin");

        assertThrows(IndexOutOfBoundsException.class, () -> languages.get(1));
    }
}
