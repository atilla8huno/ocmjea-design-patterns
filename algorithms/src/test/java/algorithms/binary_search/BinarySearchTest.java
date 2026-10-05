package algorithms.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Binary search
 *
 * Halve a sorted range each step. The loop invariant is what lo and hi
 * still mean: here, the answer (if any) stays inside [lo, hi]. Mid is
 * computed as lo + (hi - lo) / 2 so the index does not overflow.
 *
 * First occurrence keeps searching left after a hit. A rotated array
 * is still half-sorted: decide which half is ordered, then whether the
 * target sits in it. This is not Arrays.binarySearch.
 */
class BinarySearchTest {

    @Test
    void findsTheFirstCopyAndAValueInARotatedArray() {
        assertEquals(1, first(new int[]{1, 2, 2, 2, 3}, 2));
        assertEquals(-1, first(new int[]{1, 2, 2}, 4));
        assertEquals(4, rotated(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, rotated(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    private int first(int[] values, int target) {
        int low = 0;
        int high = values.length - 1;
        int found = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (values[mid] >= target) {
                if (values[mid] == target) {
                    found = mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return found;
    }

    private int rotated(int[] values, int target) {
        int low = 0;
        int high = values.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (values[mid] == target) {
                return mid;
            }
            if (values[low] <= values[mid]) {
                if (values[low] <= target && target < values[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (values[mid] < target && target <= values[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
