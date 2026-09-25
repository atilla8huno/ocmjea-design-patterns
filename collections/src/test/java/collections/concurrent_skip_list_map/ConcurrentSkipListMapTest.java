package collections.concurrent_skip_list_map;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Problem: keep a live scoreboard sorted by score and answer range queries without locking the map.
 *
 * ConcurrentSkipListMap fits because keys stay ordered and navigation methods are O(log n).
 * Use it when you need a concurrent map that is also a SortedMap.
 */
class ConcurrentSkipListMapTest {
    @Test
    void answersLeaderboardRangeQueries() {
        ConcurrentSkipListMap<Integer, String> scores = new ConcurrentSkipListMap<>();
        scores.put(50, "Ada");
        scores.put(90, "Linus");
        scores.put(70, "Grace");

        assertEquals(List.of(50, 70, 90), List.copyOf(scores.keySet()));
        assertEquals("Grace", scores.ceilingEntry(60).getValue());
        assertEquals(Map.of(70, "Grace", 90, "Linus"), scores.tailMap(70));
    }

    @Test
    void comparatorEqualityReplacesAKey() {
        ConcurrentSkipListMap<String, Integer> values = new ConcurrentSkipListMap<>(Comparator.comparingInt(String::length));
        values.put("cat", 1);
        values.put("dog", 2);

        assertEquals(Map.of("cat", 2), values);
    }
}
