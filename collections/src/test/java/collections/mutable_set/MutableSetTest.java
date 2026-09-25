package collections.mutable_set;

import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Problem: detect the first id that repeats in a stream.
 *
 * HashSet fits because add stores the value and reports whether it was new in one constant-time
 * call, so no second membership scan is needed.
 */
class MutableSetTest {
    private Integer firstRepeated(List<Integer> ids) {
        Set<Integer> seen = new HashSet<>();
        for (Integer id : ids) {
            if (!seen.add(id)) {
                return id;
            }
        }
        return null;
    }

    @Test
    void findsTheFirstRepeatedId() {
        assertEquals(3, firstRepeated(List.of(1, 2, 3, 4, 3, 2)));
        assertNull(firstRepeated(List.of(1, 2, 3)));
    }

    @Test
    void addReportsWhetherTheValueWasNew() {
        Set<String> roles = new HashSet<>();
        roles.add("reader");

        assertTrue(roles.add("writer"));
        assertFalse(roles.add("writer"));
        assertEquals(Set.of("reader", "writer"), roles);
    }

    @Test
    void structuralChangesInvalidateAnIterator() {
        Set<Integer> values = new HashSet<>(Set.of(1, 2, 3));
        Iterator<Integer> iterator = values.iterator();
        iterator.next();
        values.add(4);

        assertThrows(ConcurrentModificationException.class, iterator::next);
    }
}
