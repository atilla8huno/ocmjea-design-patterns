package collections.sorted_map;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Problem: pick the discount tier that applies to an order size and list the tiers in a range.
 *
 * TreeMap fits because floorEntry finds the greatest key not above a value in logarithmic time and
 * subMap exposes an ordered range view. floorEntry is the usual "best tier
 * not above this amount" lookup.
 */
class SortedMapTest {
    private final TreeMap<Integer, Integer> discountByMinimumItems = new TreeMap<>(Map.of(0, 0, 10, 5, 50, 10, 100, 20));

    @Test
    void findsTheTierThatAppliesToAnOrder() {
        assertEquals(5, discountByMinimumItems.floorEntry(23).getValue());
        assertEquals(20, discountByMinimumItems.floorEntry(1_000).getValue());
        assertEquals(0, discountByMinimumItems.floorEntry(0).getValue());
    }

    @Test
    void readsARangeOfTiersInKeyOrder() {
        assertEquals(List.of(10, 50), List.copyOf(discountByMinimumItems.subMap(10, 100).keySet()));
        assertEquals(List.of(0, 10, 50, 100), List.copyOf(discountByMinimumItems.keySet()));
    }

    @Test
    void comparatorEqualityReplacesAnExistingEntry() {
        TreeMap<String, Integer> values = new TreeMap<>(Comparator.comparingInt(String::length));
        values.put("cat", 1);
        values.put("dog", 2);

        assertEquals(Map.of("cat", 2), values);
    }
}
