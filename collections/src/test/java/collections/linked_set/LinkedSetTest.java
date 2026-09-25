package collections.linked_set;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Problem: keep the first occurrence of each visitor, in arrival order.
 *
 * LinkedHashSet fits because it rejects duplicates in constant time while preserving insertion
 * order, which a plain HashSet does not guarantee.
 */
class LinkedSetTest {
    @Test
    void keepsTheFirstOccurrenceOfEachVisitor() {
        Set<String> unique = new LinkedHashSet<>();
        unique.addAll(List.of("ana", "bob", "ana", "cid", "bob"));

        assertEquals(List.of("ana", "bob", "cid"), List.copyOf(unique));
    }

    @Test
    void reinsertingAnItemDoesNotMoveIt() {
        Set<String> values = new LinkedHashSet<>(List.of("a", "b"));
        values.add("a");

        assertEquals(List.of("a", "b"), List.copyOf(values));
    }
}
