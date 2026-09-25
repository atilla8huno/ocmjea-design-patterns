package collections.set;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Problem: report which ids two feeds share and which belong to only one of them.
 *
 * Set fits because membership is answered in constant time and the union, intersection and
 * difference operators express the comparison directly. HashSet is enough when
 * order does not matter.
 */
class SetTest {
    @Test
    void comparesTwoFeedsByMembership() {
        Set<Integer> yesterday = Set.of(1, 2, 3, 4);
        Set<Integer> today = Set.of(3, 4, 5);

        Set<Integer> shared = new HashSet<>(yesterday);
        shared.retainAll(today);
        Set<Integer> onlyYesterday = new HashSet<>(yesterday);
        onlyYesterday.removeAll(today);
        Set<Integer> all = new HashSet<>(yesterday);
        all.addAll(today);

        assertEquals(Set.of(3, 4), shared);
        assertEquals(Set.of(1, 2), onlyYesterday);
        assertEquals(Set.of(1, 2, 3, 4, 5), all);
    }

    @Test
    void removesDuplicatesDuringCreation() {
        Set<String> tags = Set.of("kotlin", "java");

        assertEquals(2, tags.size());
        assertTrue(tags.contains("java"));
    }

    @Test
    void equalityIgnoresIterationOrder() {
        assertEquals(Set.of(1, 2, 3), Set.of(3, 2, 1));
    }
}
