package collections.mutable_map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Problem: find the two positions whose values add up to a target, and tally word frequencies.
 *
 * HashMap fits because it doubles as a constant-time index of everything already seen, turning a
 * quadratic scan into a single pass.
 */
class MutableMapTest {
    private int[] twoSum(List<Integer> values, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int index = 0; index < values.size(); index++) {
            Integer previous = indexByValue.get(target - values.get(index));
            if (previous != null) {
                return new int[] { previous, index };
            }
            indexByValue.put(values.get(index), index);
        }
        return null;
    }

    @Test
    void findsTheTwoIndicesThatReachTheTarget() {
        assertEquals(1, twoSum(List.of(8, 2, 5, 7), 9)[0]);
        assertEquals(3, twoSum(List.of(8, 2, 5, 7), 9)[1]);
        assertNull(twoSum(List.of(1, 2, 3), 100));
    }

    @Test
    void countsOccurrencesPerKey() {
        Map<String, Integer> counts = new HashMap<>();
        for (String colour : List.of("red", "blue", "red")) {
            counts.merge(colour, 1, Integer::sum);
        }

        assertEquals(Map.of("red", 2, "blue", 1), counts);
    }
}
