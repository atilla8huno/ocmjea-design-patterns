package collections.sorted_set;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Problem: list the booking slots inside a time window and find the nearest slot around a moment.
 *
 * TreeSet fits because it keeps elements sorted and answers range, ceiling and floor queries in
 * logarithmic time.
 */
class SortedSetTest {
    private final TreeSet<Integer> slots = new TreeSet<>(List.of(9, 11, 13, 15, 17));

    @Test
    void readsTheSlotsInsideAWindow() {
        assertEquals(List.of(11, 13, 15), List.copyOf(slots.subSet(10, 16)));
        assertEquals(List.of(9, 11, 13, 15, 17), List.copyOf(slots));
    }

    @Test
    void findsTheNearestSlotAroundAMoment() {
        assertEquals(13, slots.ceiling(12));
        assertEquals(11, slots.floor(12));
        assertEquals(17, slots.last());
    }

    @Test
    void aComparatorAlsoDefinesDuplicateValues() {
        TreeSet<String> byLength = new TreeSet<>(Comparator.comparingInt(String::length));
        byLength.add("cat");
        byLength.add("dog");

        assertEquals(List.of("cat"), List.copyOf(byLength));
    }
}
