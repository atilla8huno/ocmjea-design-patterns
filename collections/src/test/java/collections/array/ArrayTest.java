package collections.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Problem: reverse a buffer in place without allocating a second collection.
 *
 * Array fits because its size is fixed at creation and elements are swapped by index, which is what
 * two-pointer algorithms need. Use an array when the length is known and fixed.
 */
class ArrayTest {
    @Test
    void reversesElementsInPlaceWithTwoPointers() {
        String[] values = { "a", "b", "c", "d" };
        int left = 0;
        int right = values.length - 1;
        while (left < right) {
            String swap = values[left];
            values[left] = values[right];
            values[right] = swap;
            left++;
            right--;
        }

        assertArrayEquals(new String[] { "d", "c", "b", "a" }, values);
    }

    @Test
    void readsAndUpdatesByIndex() {
        String[] values = { "a", "b" };
        values[1] = "c";

        assertEquals(2, values.length);
        assertEquals("c", values[1]);
    }

    @Test
    void equalityIsReferentialByDefault() {
        assertFalse(new Integer[] { 1, 2 } == new Integer[] { 1, 2 });
        assertTrue(java.util.Arrays.equals(new Integer[] { 1, 2 }, new Integer[] { 1, 2 }));
    }
}
