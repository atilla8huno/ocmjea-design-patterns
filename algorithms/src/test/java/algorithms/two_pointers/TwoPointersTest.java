package algorithms.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Two pointers and a sliding window
 *
 * On a sorted array, start at both ends. If the sum is too small, move
 * the left pointer right; if too large, move the right pointer left.
 * Each step throws away a whole range, so two-sum is linear after the
 * sort.
 *
 * A window is the same idea on a string: grow the right edge, and pull
 * the left edge forward when the window breaks the rule (here, a
 * repeated character). This test does both.
 */
class TwoPointersTest {

    @Test
    void findsAPairFromBothEndsAndTheLongestUniqueWindow() {
        assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{1, 2, 4}, 6));
        assertEquals(3, longestUnique("abcabcbb"));
        assertEquals(1, longestUnique("bbbb"));
    }

    private int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    private int longestUnique(String text) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int start = 0;
        int best = 0;
        for (int index = 0; index < text.length(); index++) {
            char letter = text.charAt(index);
            if (lastSeen.containsKey(letter) && lastSeen.get(letter) >= start) {
                start = lastSeen.get(letter) + 1;
            }
            lastSeen.put(letter, index);
            best = Math.max(best, index - start + 1);
        }
        return best;
    }
}
