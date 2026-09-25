package collections.mutable_list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Problem: merge two sorted lists into a single ordered result.
 *
 * ArrayList fits because the output size is unknown upfront: it grows on demand and appends in
 * amortised constant time.
 */
class MutableListTest {
    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));
        return merged;
    }

    @Test
    void mergesTwoSortedLists() {
        assertEquals(List.of(1, 2, 3, 4, 5, 6), merge(List.of(1, 3, 5), List.of(2, 4, 6)));
        assertEquals(List.of(1, 2, 7), merge(List.of(7), List.of(1, 2)));
    }

    @Test
    void addsUpdatesAndRemovesElements() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20));
        numbers.add(30);
        numbers.set(0, 5);
        numbers.remove(1);

        assertEquals(List.of(5, 30), numbers);
    }
}
